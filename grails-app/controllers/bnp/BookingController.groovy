package bnp

import com.bbarters.auth.Role
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class BookingController {

    @Secured(['ROLE_USER', 'ROLE_ADMIN'])
    def index() {

        if (authenticatedUser.authorities.contains(Role.findByAuthority('ROLE_ADMIN'))) {
            params.max = 5
            [bookingList: Booking.list(params), bookingCount: Booking.count()]
        } else {
            params.max = 3
            [bookingList: Booking.findAllByUser(authenticatedUser, params), bookingCount: authenticatedUser.bookings.size()]
        }

    }

    def show() {
        [booking: Booking.get(params.id)]
    }

    def create() {

        def booking = new Booking()
        booking.properties = params
        return [booking: booking, entityName: 'Booking']
    }


    def save(Booking booking) {
        if (booking == null) {
            return
        }

        booking.user = authenticatedUser
        booking.payment = new Payment(amount: params.payment.amount)

        if (booking.hasErrors()) {
            respond booking.errors, view: 'create'
            return
        }


        booking.save flush: true
        redirect(uri: "/")
    }
}
