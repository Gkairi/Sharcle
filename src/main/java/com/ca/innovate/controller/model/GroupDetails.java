package com.ca.innovate.controller.model;

import com.ca.dao.Chat;
import com.ca.dao.Group;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by talma07 on 12/29/2016.
 */
public class GroupDetails {

    private String groupId;

    private List<ChatDetails> chatList = new ArrayList<>();

    public String getGroupId() {
        return groupId;
    }

    public List<ChatDetails> getChatList() {
        return chatList;
    }

    public GroupDetails(Builder builder) {
        this.chatList = builder.chatList;
        this.groupId = builder.groupId;
    }

    public static class Builder {
        private String groupId;

        private List<ChatDetails> chatList;

        public Builder groupid(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder addchats(List<ChatDetails> chats) {
            this.chatList = chats;
            return this;
        }

        public GroupDetails build() {
            return new GroupDetails(this);

        }


    }

    public static GroupDetails dummy() {
        GroupDetails.Builder groupDetailsBuilder = new GroupDetails.Builder();
        ChatDetails.Builder chatBilder1 = new ChatDetails.Builder();
        ChatDetails.Builder chatBilder2 = new ChatDetails.Builder();
        ChatDetails.Builder chatBilder3 = new ChatDetails.Builder();

        groupDetailsBuilder.groupid("1");
        chatBilder1.groupId("1");
        chatBilder1.chatText("HI");
        chatBilder1.userId("user1");
        chatBilder1.timeStamp(String.valueOf(System.currentTimeMillis()));

        chatBilder2.groupId("1");
        chatBilder2.chatText("Buy 1 get1 offer, any body will join?");
        chatBilder2.userId("user2");
        chatBilder2.timeStamp(String.valueOf(System.currentTimeMillis()));

        List<ChatDetails> list = new ArrayList<>();
        list.add(chatBilder1.build());
        list.add(chatBilder2.build());
        groupDetailsBuilder.addchats(list);

        return groupDetailsBuilder.build();
    }


    public static List<Group> getAllGroups(String lattitude, String longitude) {

        List<Group> listOfGroups = new ArrayList<>();

        Group group1 = new Group();
        group1.setGroupName("CA");
        group1.setGpsLatitude(lattitude);
        group1.setGpsLongitude(longitude);
        group1.setGroupId("group1");
        group1.setType("Technology");
        group1.setGroupAddress("115 IT Park Area, Gachibowli");
        group1.setUuid("111222");


        listOfGroups.add(group1);
        Group group2 = new Group();
        group2.setGroupName("Wipro");
        group2.setGpsLatitude(lattitude);
        group2.setGpsLongitude(longitude);
        group2.setGroupId("group2");
        group2.setType("Technology");
        group2.setGroupAddress("116 IT Park Area, Gachibowli");
        group2.setUuid("1112223");


        listOfGroups.add(group2);

        Group group3 = new Group();
        group3.setGroupName("Mantri");
        group3.setGpsLatitude(lattitude);
        group3.setGpsLongitude(longitude);
        group3.setGroupId("group3");
        group3.setType("Technology");
        group3.setGroupAddress("126, Gachibowli");
        group3.setUuid("111222444");

        listOfGroups.add(group3);

        return listOfGroups;
    }
}
