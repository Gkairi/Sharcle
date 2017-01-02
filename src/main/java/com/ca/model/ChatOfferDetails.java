package com.ca.model;

/**
 * Created by indka01 on 1/2/2017.
 */
public class ChatOfferDetails extends ChatOffer {

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String displayName) {
        this.userDisplayName = displayName;
    }

    private String userDisplayName;
}
