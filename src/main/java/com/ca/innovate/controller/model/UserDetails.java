package com.ca.innovate.controller.model;

import java.io.Serializable;

/**
 * Created by talma07 on 12/28/2016.
 */
public class UserDetails {

    private Integer id;
    private String displayName;
    private String email;
    private String commercialUser;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommercialUser() {
        return commercialUser;
    }

    public void setCommercialUser(String commercialUser) {
        this.commercialUser = commercialUser;
    }

    public UserDetails dummy() {
        UserDetails userDetails = new UserDetails();
        userDetails.displayName = "demoUser";
        userDetails.commercialUser = "false";
        userDetails.email = "s@sharcl.com";
        return userDetails;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
