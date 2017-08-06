package com.bbarters.auth

class LondonAnnualMember extends User {

    static mapping = {
        discriminator "LON-Annual"

    }

    public void saveMembershipInfo() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date())
        c.add(Calendar.YEAR, 1);

        this.startDate = new Date()
        this.endDate = c.getTime()
        this.bookingDiscount = 0.35
    }
}
