describe('hallaoui app sign in', () => {
    it('visit hallaoui app & sign in', () => {
        cy.visit('http://91.230.110.129:3000/')
        cy.get('input[type="tel"]').type('0674478681')
        cy.contains('button', 'Continue').click()
        cy.contains('button', 'Validate').click()
    })
})
