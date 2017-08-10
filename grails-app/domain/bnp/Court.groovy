package bnp



abstract class Court {

    String name
    Integer rate
    String location

    static hasMany = [bookings: Booking]

    public abstract Integer getCost();
}
