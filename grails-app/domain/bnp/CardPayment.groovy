package bnp

import com.bbarters.services.SavePaymentInfo
import groovy.json.JsonOutput
import org.grails.web.json.JSONObject

class CardPayment extends Payment implements SavePaymentInfo {

    static mapping = {
        discriminator "card"
    }

    public void savePaymentInfo(int amt){
        this.amount = amt * 0.8
        this.payment_info = new JSONObject(JsonOutput.toJson([card_type: 'VISA', card_no: 4212345]))
    }
}
