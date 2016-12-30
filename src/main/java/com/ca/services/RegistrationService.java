package com.ca.services;

import com.ca.dao.User;

/**
 * Created by indka01 on 12/29/2016.
 */
public interface RegistrationService {

    public User registerUser(User user);
    public User findUser(String emailId);
    public User findUserByUUID(String uuid);
}
