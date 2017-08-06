package com.bbarters.auth

class NYAnnualMember extends User {

    static mapping = {
        discriminator "NY-Annual"
    }

    public void saveMembershipInfo() {
        Calendar c = Calendar.getInstance()
        c.setTime(new Date())
        c.add(Calendar.YEAR, 1)

        this.startDate = new Date()
        this.endDate = c.getTime()
        this.bookingDiscount = 0.4
    }
}
