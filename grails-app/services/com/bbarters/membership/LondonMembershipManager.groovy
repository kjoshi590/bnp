package com.bbarters.membership

import com.bbarters.auth.*
import grails.web.servlet.mvc.GrailsParameterMap

class LondonMembershipManager extends MembershipManagerService {

    public User createMember(String membership_type, GrailsParameterMap params){

        User user;
        if (membership_type == "Lifetime") {
            user = new LondonLifetimeMember(params)
        }
        else if (membership_type == "Annual"){
            user = new LondonAnnualMember(params)
        }
        else{
            user = new TempMember(params);
        }

        return user;
    }
}
