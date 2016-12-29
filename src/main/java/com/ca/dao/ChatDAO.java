package com.ca.dao;

import java.util.List;

/**
 * Created by indka01 on 12/29/2016.
 */
public interface ChatDAO {

    public boolean save(Chat chat);
    public List<Chat> getChatLastOneHour(String groupId);
}
