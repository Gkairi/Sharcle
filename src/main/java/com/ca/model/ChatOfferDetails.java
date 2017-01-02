package com.ca.model;

/**
 * Created by indka01 on 1/2/2017.
 */
public class ChatOfferDetails extends ChatOffer {

    public String getDisplayName() {
        return userDisplayName;
    }

    public void setDisplayName(String displayName) {
        this.userDisplayName = displayName;
    }

    private String userDisplayName;
}
