package com.bbarters.auth

import java.time.LocalDate

class AnnualMember extends User {

    static mapping = {
        discriminator "Annual"
    }

    public void saveMembershipInfo() {
        Calendar c = Calendar.getInstance()
        c.setTime(new Date())
        c.add(Calendar.YEAR, 1)

        this.startDate = new Date()
        this.endDate = c.getTime()
        this.bookingDiscount = 0.5
    }
}
