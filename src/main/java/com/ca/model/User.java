package com.ca.model;

/**
 * Created by indka01 on 12/28/2016.
 */
public class User {

    public String uuid;
    public String emailId;
    public String displayName;
    public String commType;
    public String imagePath ="a";
    public String userCreatedTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (userCreatedTime != that.userCreatedTime) return false;
        if (!uuid.equals(that.uuid)) return false;
        if (!emailId.equals(that.emailId)) return false;
        if (!displayName.equals(that.displayName)) return false;
        if (!commType.equals(that.commType)) return false;
        return imagePath.equals(that.imagePath);

    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + emailId.hashCode();
        result = 31 * result + displayName.hashCode();
        result = 31 * result + commType.hashCode();
        //result = 31 * result + imagePath.hashCode();
     //   result = 31 * result + (int) (userCreatedTime ^ (userCreatedTime >>> 32));
        return result;
    }



    public String getCommType() {
        return commType;
    }

    public void setCommType(String commType) {
        this.commType = commType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUserCreatedTime() {
        return userCreatedTime;
    }

    public void setUserCreatedTime(String userCreatedTime) {
        this.userCreatedTime = userCreatedTime;
    }


}
