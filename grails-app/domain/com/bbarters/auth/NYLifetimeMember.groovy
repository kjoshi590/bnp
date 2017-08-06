package com.bbarters.auth

class NYLifetimeMember extends User {

    static mapping = {
        discriminator "NY-Lifetime"

    }

    public void saveMembershipInfo() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date())
        c.add(Calendar.YEAR, 70);

        this.startDate = new Date()
        this.endDate = c.getTime()
        this.bookingDiscount = 0.1
    }

}
