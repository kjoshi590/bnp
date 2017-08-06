package com.bbarters.auth

import java.time.LocalDate

class LifetimeMember extends User {

    static mapping = {
        discriminator "Lifetime"

    }

    public void saveMembershipInfo() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date())
        c.add(Calendar.YEAR, 60);

        this.startDate = new Date()
        this.endDate = c.getTime()
        this.bookingDiscount = 0.25
    }


}
