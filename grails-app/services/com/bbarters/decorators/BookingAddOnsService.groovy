package com.bbarters.decorators

import bnp.Court
import bnp.decorators.BallPack
import bnp.decorators.Coaching
import bnp.decorators.Rackets
import grails.transaction.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class BookingAddOnsService {

    public static Integer applyAddOns(Court c, GrailsParameterMap params) {

        if (params.ballpack != null){

            c = new BallPack(c)
        }
        if (params.rackets != null){

            c = new Rackets(c)
        }
        if (params.coaching != null){

            c = new Coaching(c)
        }

        return c.getCost()
    }
}
