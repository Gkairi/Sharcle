package com.ca.services;

import com.ca.model.Chat;
import com.ca.dao.ChatDAO;
import com.ca.dao.ChatDAOImpl;
import com.ca.model.ChatDetails;

import java.util.List;

/**
 * Created by indka01 on 12/30/2016.
 */
public class ChatServiceImpl implements ChatService {

    @Override
    public List<ChatDetails> getChatHistory(String groupId) {

        ChatDAO chatDao = new ChatDAOImpl();
        return chatDao.getChatLastOneHour(groupId);


    }

    @Override
    public boolean saveChat(Chat c) {
        ChatDAO chatDao = new ChatDAOImpl();
        return chatDao.save(c);
    }
}
