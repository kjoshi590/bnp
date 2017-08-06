package com.bbarters.auth

class LondonLifetimeMember extends User {

    static mapping = {
        discriminator "LON-Lifetime"

    }

    public void saveMembershipInfo() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date())
        c.add(Calendar.YEAR, 90);

        this.startDate = new Date()
        this.endDate = c.getTime()
        this.bookingDiscount = 0.15
    }
}
