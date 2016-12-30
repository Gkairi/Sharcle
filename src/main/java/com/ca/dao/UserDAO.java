package com.ca.dao;

/**
 * Created by indka01 on 12/28/2016.
 */
public interface UserDAO {

    public boolean save(User account);
    public User findByEmailID(String emailId);
    public User findByUUID(String uuid);
    public boolean delete(User account);
}
