package com.ca.innovate.controller.model;

import com.ca.dao.Chat;

import javax.print.DocFlavor;
import java.util.List;

/**
 * Created by talma07 on 12/29/2016.
 */
public class GroupDetails {

    private String groupId;

    private List<Chat> chatList;


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }
}
