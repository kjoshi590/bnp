package bnp.decorators

import bnp.Court

class Coaching extends BookingDecorator {

    Court courtBooking;

    public Coaching(c)
    {
        this.courtBooking = c;
    }

    static constraints = {
    }

    @Override
    Integer getCost() {
        return 300 + this.courtBooking.getCost();
    }
}
