package com.bbarters.auth

import com.bbarters.services.EmailService
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic
import bnp.*

import java.time.LocalDate;

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String firstName
    String lastName
    String email
    Address userAddress
    String phone

    Date startDate
    Date endDate
    Float bookingDiscount
    String location

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired


    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static embedded = ['userAddress']
    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
    }

    static mapping = {
	    password column: '`password`'
    }

    SortedSet bookings
    static hasMany = [bookings: Booking]

    @Override
    String toString() {
        return firstName + " " + lastName
    }

    public void saveMembershipInfo(){}

    public void notifyNewMember(){
        // Let us send an email to new member
        EmailService.sendEmail(this.email)
    }
}

class Address{
    String line_1
    String line_2
    Integer pin
    String city
    String state
    String country
}