package bnp

class HardCourt extends Court {

    static mapping = {
        discriminator 'Hard'
    }

    @Override
    Integer getCost() {
        return this.rate
    }

    @Override
    String toString() {
        return  name + " (Rate: " + rate + ") - Hard"
    }

}
