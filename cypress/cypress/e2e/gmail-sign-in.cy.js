describe('gmail sign in', () => {
    it('should sign in successfully', () => {
        cy.visit('https://mail.google.com')
        cy.get('input[type="email"]').type('mehdi.mc60@gmail.com')
        cy.contains('button', 'Next').click()
        cy.get('input[type="password"]').type('your-password')
        cy.get('#passwordNext').click()
        cy.url().should('include', 'inbox')
    })
})
