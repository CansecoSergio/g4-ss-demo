import org.springframework.security.core.session.SessionRegistryImpl
import audit.sessions.ExpiringSessionEventListener
import audit.sessions.LoggingSecurityEventListener

import ssdemo.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
	loggingSecurityEventListener(LoggingSecurityEventListener)
	sessionRegistry(SessionRegistryImpl)
	expiringSessionEventListener(ExpiringSessionEventListener)

    userPasswordEncoderListener(UserPasswordEncoderListener)
}
