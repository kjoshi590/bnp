package bnp

import com.bbarters.auth.*

import groovy.transform.ToString
import org.apache.commons.lang.time.DateUtils

@ToString(includes =['id','dateOfBooking','court','payment'])
class Booking implements Comparable {

    Date dateOfBooking



    static constraints = {
        payment nullable: true
        user nullable: true
        dateOfBooking validator: { val, obj -> val >= DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH)}
    }
    static belongsTo = [user:User, court: Court]
    static hasOne = [payment: Payment]

    int compareTo(obj) {
        dateOfBooking.compareTo(obj.dateOfBooking)
    }
}
