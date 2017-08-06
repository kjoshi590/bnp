package com.bbarters.membership

import com.bbarters.auth.*

import grails.web.servlet.mvc.GrailsParameterMap

class  MumbaiMembershipManager extends MembershipManagerService {

    public User createMember(String membership_type, GrailsParameterMap params){

        User user;
        if (membership_type == "Lifetime") {
            user = new LifetimeMember(params)
        }
        else if (membership_type == "Annual"){
            user = new AnnualMember(params)
        }
        else{
            user = new TempMember(params);
        }

        return user;
    }

}
