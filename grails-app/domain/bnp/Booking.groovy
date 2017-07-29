package bnp

import com.bbarters.auth.*

import groovy.transform.ToString

@ToString(includes =['id','dateOfBooking','court','payment'])
class Booking implements Comparable {

    Date dateOfBooking


    static mapping = {
        dateOfBooking type:'timestamp' //change the type of column
    }
    static constraints = {
        payment nullable: true
        user nullable: true
    }
    static belongsTo = [user:User, court: Court]
    static hasOne = [payment: Payment]

    int compareTo(obj) {
        dateOfBooking.compareTo(obj.dateOfBooking)
    }
}
