package bnp

import com.bbarters.services.PaymentService
import grails.plugin.springsecurity.annotation.Secured
import com.bbarters.auth.*
import groovy.json.JsonOutput
import org.grails.web.json.JSONObject

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_USER'])
class BookingController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_USER','ROLE_ADMIN'])
    def index(Integer max) {
        if (authenticatedUser.authorities.contains(Role.findByAuthority(authority:'ROLE_ADMIN'))) {
            params.max = 3
            [bookingList: Booking.list(params), bookingCount: Booking.count()]
        }
            else{
                params.max=3
                [bookingList:Booking.findAllByUser(authenticatedUser,params),bookingCount:authenticatedUser.bookings.size()]
            }

        /*respond Booking.list(params), model:[bookingCount: Booking.count()]*/
    }

    def show(Booking booking) {
        respond booking
    }

    def create() {
        respond new Booking(params)
    }

    @Transactional
    def save(Booking booking) {
        if (booking == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        booking.user = authenticatedUser

        Integer bookingAmount = booking.court.rate * authenticatedUser.bookingDiscount

        JSONObject pinfo = new JSONObject(JsonOutput.toJson(params.payment_info))
        booking.payment = PaymentService.createPayment(params.payment_type,bookingAmount,pinfo)


        if (booking.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond booking.errors, view:'create'
            return
        }

        booking.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'booking.label', default: 'Booking'), booking.id])
                redirect booking
            }
            '*' { respond booking, [status: CREATED] }
        }
    }

    def edit(Booking booking) {
        respond booking
    }

    @Transactional
    def update(Booking booking) {
        if (booking == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }



        if (booking.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond booking.errors, view:'edit'
            return
        }

        booking.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'booking.label', default: 'Booking'), booking.id])
                redirect booking
            }
            '*'{ respond booking, [status: OK] }
        }
    }

    @Transactional
    def delete(Booking booking) {

        if (booking == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        booking.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'booking.label', default: 'Booking'), booking.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'booking.label', default: 'Booking'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
