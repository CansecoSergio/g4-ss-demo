package ssdemo

import org.springframework.security.access.annotation.Secured

@Secured(['ROLE_ADMIN'])
class InicioController {

    def index() {
        render(text: "Hola Mundo", contentType: "text/plain", encoding: "UTF-8")
    }

}
