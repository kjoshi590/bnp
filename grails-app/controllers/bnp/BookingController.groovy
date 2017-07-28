package bnp


import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class BookingController {

    def index(){

        params.max = 2
        [bookingList: Booking.list(params), bookingCount: Booking.count()]
    }

    def create(){

        def booking = new Booking()
        booking.properties = params
        return [booking: booking, entityName:'Booking']
    }


    def save(Booking booking) {
        if (booking == null) {
            return
        }

        booking.user = authenticatedUser
        booking.payment = new Payment(amount: params.payment.amount)

        if (booking.hasErrors()) {
            respond booking.errors, view:'create'
            return
        }


        booking.save flush:true
    }
}
