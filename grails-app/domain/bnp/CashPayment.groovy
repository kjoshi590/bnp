package bnp

import com.bbarters.services.IPaymentInfo
import org.grails.web.json.JSONObject

class CashPayment extends Payment implements IPaymentInfo {

    static mapping = {
        discriminator "Cash"
    }

    public void savePaymentInfo(int amt, JSONObject pinfo){
        this.amount = amt ;
        this.payment_info = pinfo;
    }
}
