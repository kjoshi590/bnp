package bnp

class Payment {

    Date dateCreated
    Date lastUpdated

    static mapping = {

        table 'payment_info'
        dateCreated type: 'timestamp'
        lastUpdated type: 'timestamp'
    }
}
