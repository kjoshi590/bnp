package bnp



class Court {

    String name

    static hasMany = [bookings: Booking]


    @Override
    String toString() {
        return name
    }
}
