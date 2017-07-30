package bnp

class WalletPayment extends Payment {

    static mapping = {
        discriminator "wallet"
    }
}
