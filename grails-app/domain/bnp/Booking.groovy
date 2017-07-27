package bnp

import com.bbarters.auth.*

class Booking {

    Date dateOfBooking

    static mapping = {

        dateOfBooking type:'timestamp' //change the type of column
        payment joinTable: false, column: 'payment_id'

    }

    static belongsTo = [user:User, court: Court]
    static hasOne = [payment: Payment]
}
