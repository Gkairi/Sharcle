package com.ca.services;

import com.ca.dao.User;
import com.ca.dao.UserDAO;
import com.ca.dao.UserDAOImpl;

import java.util.UUID;

/**
 * Created by indka01 on 12/29/2016.
 */
public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public User registerUser(User user) {
        UserDAO userDao = new UserDAOImpl();
        User u = userDao.findByEmailID(user.getEmailId());
        if (u == null) {
            userDao.save(user);
        }else {
            return u;
        }

        User newUser = userDao.findByEmailID(user.getEmailId());
        return newUser;
    }


    public static void main(String[] args)
    {
        User s = new User();
        s.setCommType("false");
        s.setDisplayName("asdf");
        s.setEmailId("1@gmail.com");
        s.setImagePath("asdf");
        s.setUserCreatedTime(System.currentTimeMillis()+"");
        s.setUuid(UUID.randomUUID()+"");

        RegistrationService rs = new RegistrationServiceImpl();
        rs.registerUser(s);
    }
}
