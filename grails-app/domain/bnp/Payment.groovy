package bnp

import com.bnp.usertype.JSONUserType
import groovy.transform.ToString
import org.grails.web.json.JSONObject


@ToString(includes =['amount'])
class Payment {

    Date dateCreated
    Date lastUpdated
    Integer amount
    JSONObject payment_info
    Booking booking




    static constraints = {
        amount min: 100
        payment_info type: JSONUserType
    }

    @Override
    String toString() {
        return amount
    }
}
