package bnp

class NetbankingPayment extends Payment{

    static mapping = {
        discriminator "netbanking"
    }
}
