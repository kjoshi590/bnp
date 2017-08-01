package com.bbarters.services;

import bnp.Payment;
import org.grails.web.json.JSONObject;

public interface SavePaymentInfo {

    public void savePaymentInfo(int amount, JSONObject paymentInfo);
}
