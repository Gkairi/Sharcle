package com.ca.services;

import com.ca.dao.Chat;
import com.ca.dao.ChatDAO;
import com.ca.dao.ChatDAOImpl;

import java.util.List;

/**
 * Created by indka01 on 12/30/2016.
 */
public class ChatServiceImpl implements ChatService {

    @Override
    public List<Chat> getChatHistory(String groupId) {

        ChatDAO chatDao = new ChatDAOImpl();
        return chatDao.getChatLastOneHour(groupId);


    }

    @Override
    public boolean saveChat(Chat c) {
        ChatDAO chatDao = new ChatDAOImpl();
        return chatDao.save(c);
    }
}
