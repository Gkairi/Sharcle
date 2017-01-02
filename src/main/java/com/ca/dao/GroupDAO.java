package com.ca.dao;

import com.ca.model.Group;

/**
 * Created by indka01 on 12/29/2016.
 */
public interface GroupDAO {

    public boolean save(Group group);
    public Group findByGroupId(String groupId);
    public boolean delete(Group group);
}
