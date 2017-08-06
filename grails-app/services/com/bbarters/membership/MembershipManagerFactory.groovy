package com.bbarters.membership

class MembershipManagerFactory {

    public static MembershipManagerService createMembershipManagerService(String location){

        MembershipManagerService m;
        if (location == "Mumbai")
        {
              m = new MumbaiMembershipManager();

        }
        else if (location == "NewYork") {
            m = new NYMembershipManager();
        }
        else
        {
            m = new LondonMembershipManager();
        }
        return m;
    }
}
