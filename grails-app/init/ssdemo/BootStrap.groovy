package ssdemo

import grails.gorm.transactions.Transactional
import security.Role
import security.RoleGroup
import security.RoleGroupRole
import security.Usuario
import security.UsuarioRole
import security.UsuarioRoleGroup

class BootStrap {

    def init = { servletContext ->
        addTestUser()
    }

    def destroy = {
    }

    @Transactional
    void addTestUser() {
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def testUser = new Usuario(username: 'me', password: 'password').save()
        def adminRoleGroup = new RoleGroup(name: 'ADMIN_GROUP').save()

        /*UsuarioRole.create testUser, adminRole
        UsuarioRole.withSession {
            it.flush()
            it.clear()
        }*/

        RoleGroupRole.create adminRoleGroup, adminRole
        RoleGroupRole.withSession {
            it.flush()
            it.clear()
        }

        UsuarioRoleGroup.create testUser, adminRoleGroup
        UsuarioRoleGroup.withSession {
            it.flush()
            it.clear()
        }

        assert Usuario.count() == 1
        assert Role.count() == 1
        assert RoleGroup.count() == 1
        //assert UsuarioRole.count() == 1
        assert RoleGroupRole.count() == 1
        assert UsuarioRoleGroup.count() == 1
    }
}
