package bnp

class GrassCourt extends Court {

    static mapping = {

        discriminator 'Grass'
    }

    @Override
    Integer getCost() {
        return this.rate
    }


    @Override
    String toString() {
        return  name + " (Rate: " + rate + ") - Grass"
    }

}
