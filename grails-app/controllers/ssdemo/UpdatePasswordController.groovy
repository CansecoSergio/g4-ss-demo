package ssdemo

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import security.Usuario

@Secured(['ROLE_ADMIN'])
class UpdatePasswordController {

    def springSecurityService
    def passwordEncoder

    def index() {
        Usuario usuario = springSecurityService?.currentUser

        render view: 'index', model: [username: usuario.username]
    }

    @Transactional
    def updatePassword(String password, String password_new, String password_new_2) {
        Usuario usuario = springSecurityService?.currentUser
        if (!usuario.username) {
            flash.message = 'Sorry, an error has occurred'
            redirect controller: 'login', action: 'auth'
            return
        }

        if (!password || !password_new || !password_new_2 || password_new != password_new_2) {
            flash.message = 'Please enter your current password and a valid new password'
            render view: 'index', model: [username: session['SPRING_SECURITY_LAST_USERNAME']]
            return
        }

        if (!passwordEncoder.matches(password, usuario.password)) {
            flash.message = 'Current password is incorrect'
            render view: 'index', model: [username: session['SPRING_SECURITY_LAST_USERNAME']]
            return
        }

        if (passwordEncoder.matches(password_new, usuario.password)) {
            flash.message = 'Please choose a different password from your current one'
            render view: 'index', model: [username: session['SPRING_SECURITY_LAST_USERNAME']]
            return
        }

        Usuario usuarioBD = Usuario.findByUsername(usuario.username)

        //log.info passwordEncoder
        log.info password_new + " - " + password_new_2

        usuarioBD.password = password_new
        usuarioBD.passwordExpired = false
        usuarioBD.save()// if you have password constraints check them here

        redirect controller: 'logout'
    }
}
