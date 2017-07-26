package bnp

import com.bbarters.auth.*

class BootStrap {

    def init = { servletContext ->

        def adminRole = Role.findOrSaveWhere(authority: 'ROLE_ADMIN')
        def userRole = Role.findOrSaveWhere(authority: 'ROLE_USER')

        def admin = User.findOrSaveWhere(username:'ksjoshi88', password: 'kastya',firstName: 'Kaustubh', lastName: 'Joshi', email: 'ksjoshi88@gmail.com')
        def user = User.findOrSaveWhere(username:'ritesh', password: 'ritu',firstName: 'Ritesh', lastName: 'Bhagat', email: 'ritesh94@gmail.com')


        if(!admin.authorities.contains(adminRole)){
            UserRole.create(admin,adminRole,true)
        }

        if(!user.authorities.contains(adminRole)){
            UserRole.create(user,userRole,true)
        }

    }
    def destroy = {
    }
}
