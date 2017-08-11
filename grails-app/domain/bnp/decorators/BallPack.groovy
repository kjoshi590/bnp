package bnp.decorators

import bnp.Court

class BallPack extends BookingDecorator {

    Court courtBooking;



    public BallPack(Court c)
    {
        this.courtBooking = c;
    }

    static constraints = {
    }

    @Override
    Integer getCost() {
        return 200 + this.courtBooking.getCost();
    }
}
