package bnp

class Payment {

    Date dateCreated
    Date lastUpdated
    Integer amount

    static mapping = {

        dateCreated type: 'timestamp'
        lastUpdated type: 'timestamp'
    }

    static belongsTo = [booking:Booking]
}
