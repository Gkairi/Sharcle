package com.ca.dao;

/**
 * Created by indka01 on 12/29/2016.
 */
public class Group {

    /*
    group table
    UUID varchar(254) NOT NULL,
  Group_id varchar(254) NOT NULL,
  Group_Name varchar(254) NOT NULL,
  Group_address varchar(254),
  GPS_Latitude varchar(254),
  GPS_Longitude varchar(254),
  Time_stamp long,
  Type varchar(30),
     */

    private String uuid;
    private String groupId;
    private String groupName;
    private String groupAddress;
    private String gpsLatitude;
    private String gpsLongitude;
    private String timeStamp;
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!uuid.equals(group.uuid)) return false;
        if (!groupId.equals(group.groupId)) return false;
        if (!groupName.equals(group.groupName)) return false;
        if (!groupAddress.equals(group.groupAddress)) return false;
        if (!gpsLatitude.equals(group.gpsLatitude)) return false;
        if (!gpsLongitude.equals(group.gpsLongitude)) return false;
        if (!timeStamp.equals(group.timeStamp)) return false;
        return type.equals(group.type);

    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + groupId.hashCode();
        result = 31 * result + groupName.hashCode();
        result = 31 * result + groupAddress.hashCode();
        result = 31 * result + gpsLatitude.hashCode();
        result = 31 * result + gpsLongitude.hashCode();
        result = 31 * result + timeStamp.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }



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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupAddress() {
        return groupAddress;
    }

    public void setGroupAddress(String groupAddress) {
        this.groupAddress = groupAddress;
    }

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
