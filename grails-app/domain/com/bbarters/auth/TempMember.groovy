package com.bbarters.auth

class TempMember extends User {

    static mapping = {
        discriminator "Temporary"
    }

    public void saveMembershipInfo() {
        this.startDate = new Date()
        this.endDate = new Date()
        this.bookingDiscount = 1
    }
}
