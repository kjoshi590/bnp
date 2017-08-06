package bnp

import com.bbarters.services.IPaymentInfo
import org.grails.web.json.JSONObject

class CardPayment extends Payment implements IPaymentInfo {

    static mapping = {
        discriminator "Card"
    }

    public void savePaymentInfo(int amt, JSONObject pinfo){
        this.amount = (amt * 0.8)
        this.payment_info = pinfo
    }
}
