package bnp.decorators

import bnp.Court

abstract class BookingDecorator extends Court {

    static constraints = {
    }
    public abstract Integer getCost();
}
