package bnp

import grails.plugin.springsecurity.annotation.Secured


@Secured(['ROLE_ADMIN','ROLE_USER'])
class MainController {


    def index() {

     [user: authenticatedUser]
    }

}
