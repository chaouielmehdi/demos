describe('tlscontact rendez-vous', () => {
    it('should sign in successfully', () => {
        cy.visit('https://auth.visas-fr.tlscontact.com/auth/realms/atlas/protocol/openid-connect/auth?response_type=code&client_id=web_app&scope=openid%20roles%20atlas%20web-origins%20email%20offline_access%20profile%20address%20phone&state=KJ9PAIpZTOihHoDfuXQIwk2rLykQIZ_OffzIztplJ-4%3D&redirect_uri=https://visa-fr.tlscontact.com/login/oauth2/code/oidc&issuer=');

        cy.get('input[id="username"]').type('noryoussef893@gmail.com')
        cy.get('input[id="password"]').type('NORyoussef99+')
        cy.contains('button', ' Log in ').click()

        cy.wait(5000)
        cy.get('.tls-input-select').select('Option Value');
    })
})
