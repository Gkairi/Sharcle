package com.ca.dao;

/**
 * Created by indka01 on 12/30/2016.
 */
public class ChatOffer {

    /*
    SELECT UUID, Group_id, Offer_id, Offer_type, Description, Offer_Starttime, Offer_endtime, User_Id, Offer_image
FROM SHARCLE.ChatOffer;
     */

    private String uuid;
    private String groupId;
    private String offerId;
    private String offerType;
    private String offerDesc;
    private String offerStartTime;
    private String offerEndTime;
    private String userId;
    private String offerImgPath;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getOfferDesc() {
        return offerDesc;
    }

    public void setOfferDesc(String offerDesc) {
        this.offerDesc = offerDesc;
    }

    public String getOfferStartTime() {
        return offerStartTime;
    }

    public void setOfferStartTime(String offerStartTime) {
        this.offerStartTime = offerStartTime;
    }

    public String getOfferEndTime() {
        return offerEndTime;
    }

    public void setOfferEndTime(String offerEndTime) {
        this.offerEndTime = offerEndTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOfferImgPath() {
        return offerImgPath;
    }

    public void setOfferImgPath(String offerImgPath) {
        this.offerImgPath = offerImgPath;
    }


}
