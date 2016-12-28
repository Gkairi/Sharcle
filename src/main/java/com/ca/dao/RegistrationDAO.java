package com.ca.dao;

/**
 * Created by indka01 on 12/28/2016.
 */
public interface RegistrationDAO {

    public boolean save(Registration account);
    public boolean update(Registration account);
    public boolean findByEmailID(String emailId);
    public boolean delete(Registration account);
}
