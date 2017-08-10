package bnp

class ClayCourt extends Court {

    static mapping = {

        discriminator 'Clay'
    }

    @Override
    Integer getCost() {
        return this.rate
    }

    @Override
    String toString() {
        return  name + " (Rate: " + rate + ") - Clay"
    }


}
