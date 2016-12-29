package com.ca.dao;

/**
 * Created by indka01 on 12/29/2016.
 */
public class Chat {
    /*
     UUID varchar(254) NOT NULL,
  Group_id varchar(254) NOT NULL,
  Chat_text varchar(254) NOT NULL,
  User_Id varchar(30) NOT NULL,
  Time_stamp long,

     */

    private String uuid;
    private String groupId;
    private String chatText;
    private String userId;
    private String timeStamp;

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

    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }




}
