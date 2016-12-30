package com.ca.services;

import com.ca.dao.Chat;

import java.util.List;

/**
 * Created by indka01 on 12/30/2016.
 */
public interface ChatService {

    public List<Chat> getChatHistory(String groupId);
    public  boolean saveChat(Chat c);
}
