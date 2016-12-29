package com.ca.innovate.controller;

import com.ca.dao.Chat;
import com.ca.dao.Group;
import com.ca.innovate.controller.dummyData.SharcleData;
import com.ca.innovate.controller.model.GroupDetails;
import com.ca.innovate.controller.model.UserDetails;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by talma07 on 12/28/2016.
 */

@RestController
@RequestMapping("api/v1/sharcle/")


public class SharcleController {


    @RequestMapping(value = "user", method = RequestMethod.GET)
    public UserDetails create(@RequestParam("displayName") String displayname, @RequestParam("email") String email,
                              @RequestParam("commercialUser") String commercialUser) {
        UserDetails userDetails = new UserDetails();
        userDetails.setDisplayName(displayname);
        userDetails.setCommercialUser(commercialUser);
        userDetails.setEmail(email);
        userDetails.setId(email.hashCode());

        return userDetails;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public UserDetails getUser(@PathVariable Long id) {
        UserDetails userDetails = new UserDetails();
        return userDetails.dummy();


    }

    @RequestMapping(value = "groups", method = RequestMethod.GET)
    public List<Group> getAvailableGroups(@RequestParam("longitude") String longitude, @RequestParam("lattitude") String lattitude) {
        List<Group> listOfGroups = new ArrayList<>();

         Group group1 = new Group();
        group1.setGroupName("CA");
        group1.setGpsLatitude(lattitude);
        group1.setGpsLongitude(longitude);
        group1.setGroupId("group1");
        group1.setType("Technology");
        group1.setGroupAddress("115 IT Park Area, Gachibowli");
        group1.setUuid("111222");


        listOfGroups.add(group1);
        Group group2 = new Group();
        group2.setGroupName("Wipro");
        group2.setGpsLatitude(lattitude);
        group2.setGpsLongitude(longitude);
        group2.setGroupId("group2");
        group2.setType("Technology");
        group2.setGroupAddress("116 IT Park Area, Gachibowli");
        group2.setUuid("1112223");



        listOfGroups.add(group2);

        Group group3 = new Group();
        group3.setGroupName("Mantri");
        group3.setGpsLatitude(lattitude);
        group3.setGpsLongitude(longitude);
        group3.setGroupId("group3");
        group3.setType("Technology");
        group3.setGroupAddress("126, Gachibowli");
        group3.setUuid("111222444");

        listOfGroups.add(group3);


        return listOfGroups;
    }

    @RequestMapping(value = "groups/{groupId}/chat", method = RequestMethod.GET)
    public Boolean send(@PathVariable("groupId") String groupId, @RequestParam("userId") String userId, @RequestParam("message") String message) {
        return true;
    }

    @RequestMapping(value = "groups/{groupId}", method = RequestMethod.GET)
    public GroupDetails getGroupChat(@PathParam("groupId") String groupId) {
        GroupDetails groupDetails = new GroupDetails();
        groupDetails.setGroupId("1");
        Chat chat1 = new Chat();
        chat1.setGroupId("1");
        chat1.setChatText("HI");
        chat1.setUserId("user1");
        chat1.setTimeStamp(String.valueOf(System.currentTimeMillis()));

        Chat chat2 = new Chat();
        chat2.setGroupId("1");
        chat2.setChatText("Buy 1 get1 offer, any body will join?");
        chat2.setUserId("user2");
        chat2.setTimeStamp(String.valueOf(System.currentTimeMillis()));

        List<Chat> list = new ArrayList<>();
        list.add(chat1);
        list.add(chat2);
        groupDetails.setChatList(list);


        return groupDetails;
    }

}
