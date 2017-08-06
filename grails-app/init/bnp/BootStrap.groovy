package bnp

import com.bbarters.auth.*

class BootStrap {

    def init = { servletContext ->

        def adminRole = Role.findOrSaveWhere(authority: 'ROLE_ADMIN')
        def userRole = Role.findOrSaveWhere(authority: 'ROLE_USER')

//        def admin = User.findOrSaveWhere(username: 'ksjoshi88', password: 'kastya', firstName: 'Kaustubh', lastName: 'Joshi', email: 'ksjoshi88@gmail.com',
//                userAddress: new Address(line_1: 'abc', line_2: 'baner', pin: 411045, city: 'Pune', state: 'MH', country: 'INDIA'))
//        def user = User.findOrSaveWhere(username: 'ritesh', password: 'ritu', firstName: 'Ritesh', lastName: 'Bhagat', email: 'ritesh94@gmail.com',
//                userAddress: new Address(line_1: 'abc', line_2: 'baner', pin: 411045, city: 'Pune', state: 'MH', country: 'INDIA'))
//
//        if (!admin.authorities.contains(adminRole)) {
//            UserRole.create(admin, adminRole, true)
//        }
//
//        if (!user.authorities.contains(adminRole)) {
//            UserRole.create(user, userRole, true)
//        }

        //creating the courts
        Court.findOrSaveWhere(name: 'Court 1', rate: 300)
        Court.findOrSaveWhere(name: 'Court 2', rate: 250)
        Court.findOrSaveWhere(name: 'Court 3', rate: 200)
        Court.findOrSaveWhere(name: 'Court 4', rate: 200)

    }
    def destroy = {
    }
}
