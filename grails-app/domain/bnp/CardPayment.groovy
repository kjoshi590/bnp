package bnp

class CardPayment extends Payment {

    static mapping = {
        discriminator "card"
    }
}
