package com.bbarters.membership

import com.bbarters.auth.AnnualMember
import com.bbarters.auth.NYAnnualMember
import com.bbarters.auth.NYLifetimeMember
import com.bbarters.auth.TempMember
import com.bbarters.auth.User
import grails.web.servlet.mvc.GrailsParameterMap

class NYMembershipManager extends MembershipManagerService {

    public User createMember(String membership_type, GrailsParameterMap params){

        User user;
        if (membership_type == "Lifetime") {
            user = new NYLifetimeMember(params)
        }
        else if (membership_type == "Annual"){
            user = new NYAnnualMember(params)
        }
        else{
            user = new TempMember(params);
        }

        return user;
    }
}
