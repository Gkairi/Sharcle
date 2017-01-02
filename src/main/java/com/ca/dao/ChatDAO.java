package com.ca.dao;

import com.ca.model.Chat;
import com.ca.model.ChatDetails;

import java.util.List;

/**
 * Created by indka01 on 12/29/2016.
 */
public interface ChatDAO {

    public boolean save(Chat chat);
    public List<ChatDetails> getChatLastOneHour(String groupId);
}
