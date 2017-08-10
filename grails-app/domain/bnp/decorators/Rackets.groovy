package bnp.decorators

import bnp.Court

class Rackets extends BookingDecorator {

    Court courtBooking;

    public Rackets(Court c)
    {
        this.courtBooking = c;
    }


    static constraints = {
    }

    @Override
    Integer getCost() {
        return 250 + this.courtBooking.getCost();
    }
}
