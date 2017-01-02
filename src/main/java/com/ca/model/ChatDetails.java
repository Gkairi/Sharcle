package com.ca.model;

/**
 * Created by indka01 on 12/30/2016.
 */
public class ChatDetails extends Chat {

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    private String userDisplayName;
}
