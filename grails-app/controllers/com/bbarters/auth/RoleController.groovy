package com.bbarters.auth

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class RoleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Role.list(params), model:[roleCount: Role.count()]
    }

    def show(Role role) {
        respond role
    }

    def create() {
        respond new Role(params)
    }

    @Transactional
    def save(Role role) {
        if (role == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (role.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond role.errors, view:'create'
            return
        }

        role.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'role.label', default: 'Role'), role.id])
                redirect role
            }
            '*' { respond role, [status: CREATED] }
        }
    }

    def edit(Role role) {
        respond role
    }

    @Transactional
    def update(Role role) {
        if (role == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (role.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond role.errors, view:'edit'
            return
        }

        role.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'role.label', default: 'Role'), role.id])
                redirect role
            }
            '*'{ respond role, [status: OK] }
        }
    }

    @Transactional
    def delete(Role role) {

        if (role == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        role.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'role.label', default: 'Role'), role.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'role.label', default: 'Role'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
