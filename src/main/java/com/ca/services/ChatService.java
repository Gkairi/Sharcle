package com.ca.services;

import com.ca.model.Chat;
import com.ca.model.ChatDetails;

import java.util.List;

/**
 * Created by indka01 on 12/30/2016.
 */
public interface ChatService {

    public List<ChatDetails> getChatHistory(String groupId);
    public  boolean saveChat(Chat c);
}
