package com.bbarters.membership

import com.bbarters.auth.AnnualMember
import com.bbarters.auth.LifetimeMember
import com.bbarters.auth.TempMember
import com.bbarters.auth.User
import grails.web.servlet.mvc.GrailsParameterMap

class MemberFactory {

    public static User createMember(String membership_type, GrailsParameterMap params)
    {
        User user;
        if (membership_type == "Lifetime") {
            user = new LifetimeMember(params);
        }
        else if (membership_type == "Annual"){
            user = new AnnualMember(params);
        }
        else{
            user = new TempMember(params);
        }

        return user;

    }
}
