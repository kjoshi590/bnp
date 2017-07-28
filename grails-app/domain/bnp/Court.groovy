package bnp

import groovy.transform.ToString

@ToString(includes =['name'])
class Court {

    String name

    static hasMany = [bookings: Booking]

}
