package ssdemo

import grails.gorm.transactions.Transactional
import org.springframework.security.access.annotation.Secured

@Secured(['ROLE_ADMIN'])
class ColorController {

    @Transactional
    def index() {
        def color = new Color(nombre: "Blue").save()
        render(text: "Se creó un colo Azul!", contentType: "text/plain", encoding: "UTF-8")
    }
}
