package bnp

import groovy.transform.ToString

@ToString(includes =['amount'])
class Payment {

    Date dateCreated
    Date lastUpdated
    Integer amount
    Booking booking

    static mapping = {

        dateCreated type: 'timestamp'
        lastUpdated type: 'timestamp'
    }

    static constraints = {
        amount min: 100
    }

    @Override
    String toString() {
        return amount
    }
}
