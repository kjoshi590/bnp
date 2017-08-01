package bnp

import com.bbarters.services.SavePaymentInfo
import grails.converters.JSON
import groovy.json.JsonOutput
import org.grails.web.json.JSONObject

class CardPayment extends Payment implements SavePaymentInfo {

    static mapping = {
        discriminator "card"
    }

    public void savePaymentInfo(int amt, JSONObject pinfo){
        this.amount = amt * 0.8
        this.payment_info = pinfo
    }
}
