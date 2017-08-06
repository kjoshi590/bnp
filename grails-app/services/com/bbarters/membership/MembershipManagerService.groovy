package com.bbarters.membership

import com.bbarters.auth.User
import grails.transaction.Transactional
import grails.web.servlet.mvc.GrailsParameterMap


abstract class MembershipManagerService {

    public User createMembership(String mType, GrailsParameterMap params)
    {
        User user
        user = createMember(mType,params)
        user.saveMembershipInfo()
        user.notifyNewMember()
        return user
    }

    public abstract User createMember(String membership_type, GrailsParameterMap params);
}
