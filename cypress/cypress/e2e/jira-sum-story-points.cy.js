const SPRINT_NUMBER = 'sprint 0';
const DOMAIN = 'https://chaouielmehdii.atlassian.net';

const searchUrl = (jql) => {
    const fields = 'key,summary,customfield_10016,creator,assignee,subtasks';
    return `${DOMAIN}/rest/api/latest/search?maxResults=${100}&jql=${encodeURIComponent(jql)}&fields=${encodeURIComponent(fields)}&expand=subtasks`
}

const jqlToFetchParent = () => {
    return `project = Hallaoui AND type != Sub-task AND summary ~ "${SPRINT_NUMBER}"`;
}

const jqlToFetchSubTasks = (sprintKey) => {
    return `project = Hallaoui AND type = Sub-task AND parent = ${sprintKey} ORDER BY created ASC`;
}

const signIn = () => {
    cy.visit(`${DOMAIN}/login`)
    cy.get('#username').type('chaouielmehdii@gmail.com')
    cy.contains('button', 'Continue').click()
    cy.get('#password').type('Mehdi@ouafae9595')
    cy.contains('button', 'Log in').click()
    cy.wait(10000)
}

const signOut = () => {
    cy.wait(10000)
    cy.visit(`${DOMAIN}/logout`)
    cy.contains('button', 'Log out').click()
}

describe('sum jira story points', () => {
    it('test', () => {
        signIn()

        let sprintKey = '';
        let result = [];
        cy.request({url: searchUrl(jqlToFetchParent())})
            .then((response) => {
                result.push(SPRINT_NUMBER + ' : (' + response.body.issues[0].fields.subtasks.length + ' tickets)')
                sprintKey = response.body.issues[0].key
            })
            .then(() => {
                cy.request({url: searchUrl(jqlToFetchSubTasks(sprintKey))})
                    .then((response) => {
                        const issues = response.body.issues.map(issue => ({
                            key: issue.key,
                            summary: issue.fields.summary,
                            assignee: issue.fields.assignee?.displayName,
                            storyPoints: issue.fields.customfield_10016
                        }))
                        const assignees = issues.group(({assignee}) => assignee)
                        for (const [key, value] of Object.entries(assignees)) {
                            const sum = value.map((ticket) => ticket.storyPoints).reduce((acc, curr) => acc + curr, 0);
                            result.push(key + ' : ' + value.length + ' tickets - ' + sum + ' points')
                        }
                    })
            })
            .then(() => {
                result = result.reduce((acc, curr) => acc + curr + '\n', '')
                cy.writeFile("cypress/e2e/jira-sum-story-points.result.txt", result)
            })

        signOut()
    })
})
