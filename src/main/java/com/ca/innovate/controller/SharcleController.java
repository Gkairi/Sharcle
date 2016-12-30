package com.ca.innovate.controller;

import com.ca.dao.Chat;
import com.ca.dao.Group;
import com.ca.innovate.controller.dummyData.SharcleData;
import com.ca.innovate.controller.model.ChatDetails;
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

        UserDetails.Builder userBuilder = new UserDetails.Builder();
        userBuilder.commercialUser(commercialUser);
        userBuilder.email(email);
        userBuilder.displayName(displayname);
        return userBuilder.build();
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public UserDetails getUser(@PathVariable Long id) {
        return UserDetails.dummy();

    }

    @RequestMapping(value = "groups", method = RequestMethod.GET)
    public List<Group> getAvailableGroups(@RequestParam("longitude") String longitude, @RequestParam("lattitude") String lattitude) {

        return GroupDetails.getAllGroups(longitude, lattitude);


    }

    @RequestMapping(value = "groups/{groupId}/chat", method = RequestMethod.GET)
    public Boolean send(@PathVariable("groupId") String groupId, @RequestParam("userId") String userId, @RequestParam("message") String message) {
        return true;
    }

    @RequestMapping(value = "groups/{groupId}", method = RequestMethod.GET)
    public GroupDetails getGroupChat(@PathParam("groupId") String groupId) {
        return GroupDetails.dummy();
    }

}
