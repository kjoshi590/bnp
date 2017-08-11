package bnp

import com.bbarters.auth.*
import com.bbarters.services.PaymentService
import org.grails.web.json.JSONObject

import java.util.concurrent.ThreadLocalRandom

class BootStrap {

    def init = { servletContext ->

        def adminRole = Role.findOrSaveWhere(authority: 'ROLE_ADMIN')
        def userRole = Role.findOrSaveWhere(authority: 'ROLE_USER')

        def admin = LifetimeMember.findOrSaveWhere(username: 'ksjoshi88', password: 'kastya', firstName: 'Kaustubh', lastName: 'Joshi', email: 'ksjoshi88@gmail.com',
                userAddress: new Address(line_1: 'abc', line_2: 'baner', pin: 411045, city: 'Pune', state: 'MH', country: 'INDIA'), bookingDiscount: 0.5f,startDate: new Date(), endDate: new Date(2077,8,11), location:'London', phone:'12345')
        def user = LifetimeMember.findOrSaveWhere(username: 'ritesh', password: 'ritu', firstName: 'Ritesh', lastName: 'Bhagat', email: 'ritesh94@gmail.com',
                userAddress: new Address(line_1: 'abc', line_2: 'baner', pin: 411045, city: 'Pune', state: 'MH', country: 'INDIA'),bookingDiscount: 0.5f,startDate: new Date(),endDate: new Date(2077,8,11), location: 'NewYork', phone: '12345')

        if (!admin.authorities.contains(adminRole)) {
            UserRole.create(admin, adminRole, true)
        }

        if (!user.authorities.contains(userRole)) {
            UserRole.create(user, userRole, true)
        }

        String[] usernames = ["ritesh","jamila","popat","hakka","baburao"].toArray()
        String[] firstNames = ["Mandan","Badan","Chandan","Kundan","Pundan"].toArray()
        String[] lastNames = ["Apte","Zapte","Chotte","Satte","Jutte"].toArray()


        (1..200).each{
            def uname = BootStrap.getRandom(usernames) + it
            def fname = BootStrap.getRandom(firstNames)
            def lname = BootStrap.getRandom(lastNames)

            user = LifetimeMember.findOrSaveWhere(username: uname, password: 'ritu', firstName: fname, lastName: lname, email: 'ritesh94@gmail.com',
                    userAddress: new Address(line_1: 'abc', line_2: 'baner', pin: 411045, city: 'Pune', state: 'MH', country: 'INDIA'),bookingDiscount: 0.5f,startDate: new Date(),endDate: new Date(2077,8,11), location: 'NewYork', phone: '12345')
            UserRole.create(user, userRole, true)
        }

        //creating the courts
        HardCourt.findOrSaveWhere(name: 'NY-Court 1', rate: 300, location: "NY")
        HardCourt.findOrSaveWhere(name: 'MUM-Court 1', rate: 300, location: "MUM")
        HardCourt.findOrSaveWhere(name: 'LON-Court 1', rate: 300, location: "LON")
        ClayCourt.findOrSaveWhere(name: 'NY-Court 2', rate: 200, location: "NY")
        ClayCourt.findOrSaveWhere(name: 'MUM-Court 2', rate: 200, location: "MUM")
        ClayCourt.findOrSaveWhere(name: 'LON-Court 2', rate: 200, location: "LON")
        GrassCourt.findOrSaveWhere(name: 'NY-Court 3', rate: 400, location: "NY")
        GrassCourt.findOrSaveWhere(name: 'MUM-Court 3', rate: 400, location: "MUM")
        GrassCourt.findOrSaveWhere(name: 'LON-Court 3', rate: 400, location: "LON")


        //creating bookings

        String[] paymentTypes = ["Cash","Card","Wallet","Netbanking"].toArray()
        def court = null
        JSONObject pinfo = new JSONObject()
        (1..200).each{

            int randomUserId = ThreadLocalRandom.current().nextInt(1, 200);
            user = User.get(randomUserId)
            int randomCourtId = ThreadLocalRandom.current().nextInt(1, 9);
            court = Court.get(randomCourtId)
            Booking b = new Booking()
            b.user = user
            b.court = court

            b.dateOfBooking = new Date()
            b.payment = PaymentService.createPayment(BootStrap.getRandom(paymentTypes),b.court.getCost(),pinfo)
            b.save flush:true

        }


    }
    def destroy = {
    }

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
