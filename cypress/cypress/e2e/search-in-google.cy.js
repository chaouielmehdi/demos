describe('search in google', () => {
    it('visit google and search for something', () => {
        cy.visit('https://www.google.com/')
        cy.get('.gLFyf').type("youssef nor").type('{enter}')
    })
})
