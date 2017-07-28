package bnp

import groovy.transform.ToString

@ToString(includes =['amount'])
class Payment {

    Date dateCreated
    Date lastUpdated
    Integer amount

    static mapping = {

        dateCreated type: 'timestamp'
        lastUpdated type: 'timestamp'
    }


}
