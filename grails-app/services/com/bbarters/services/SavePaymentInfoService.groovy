package com.bbarters.services

import bnp.CardPayment
import bnp.Payment
import groovy.json.JsonOutput;
import grails.transaction.Transactional

@Transactional
class SavePaymentInfoService {

    public static Payment createPayment(String paymentType, Integer amt) {

        def instance = Class.forName("bnp." + paymentType+"Payment").newInstance()
        savePaymentDetails(instance,amt)
        return instance
    }

    private static void savePaymentDetails(SavePaymentInfo p, Integer amount)
    {
        p.savePaymentInfo(amount)
    }
}
