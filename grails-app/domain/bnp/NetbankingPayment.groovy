package bnp

import com.bbarters.services.IPaymentInfo
import org.grails.web.json.JSONObject

class NetbankingPayment extends Payment implements IPaymentInfo{

    static mapping = {
        discriminator "Netbanking"
    }

    public void savePaymentInfo(int amt, JSONObject pinfo){
        this.amount = amt * 0.85;
        this.payment_info = pinfo;
    }
}
