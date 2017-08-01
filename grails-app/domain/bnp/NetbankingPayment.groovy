package bnp

import com.bbarters.services.SavePaymentInfo
import org.grails.web.json.JSONObject

class NetbankingPayment extends Payment implements SavePaymentInfo{

    static mapping = {
        discriminator "netbanking"
    }

    public void savePaymentInfo(int amt, JSONObject pinfo){
        this.amount = amt * 0.8
        this.payment_info = pinfo
    }
}
