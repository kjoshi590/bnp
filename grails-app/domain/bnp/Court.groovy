package bnp



class Court {

    String name
    Integer rate

    static hasMany = [bookings: Booking]


    @Override
    String toString() {
        return name + " (Rs " + rate + ")"
    }
}
