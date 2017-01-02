package com.ca.services;

import com.ca.model.Group;

import java.util.List;

/**
 * Created by indka01 on 12/29/2016.
 */
public interface GroupService {

    public List<Group> getGroupList(String latitude,String longitude);

}
