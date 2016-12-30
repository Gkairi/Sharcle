package com.ca.innovate.controller;

import com.ca.dao.Chat;
import com.ca.dao.ChatDetails;
import com.ca.dao.Group;
import com.ca.dao.User;
import com.ca.innovate.controller.dummyData.SharcleData;
import com.ca.innovate.controller.model.GroupDetails;
import com.ca.innovate.controller.model.UserDetails;
import com.ca.services.ChatService;
import com.ca.services.GroupService;
import com.ca.services.RegistrationService;
import com.ca.services.ServiceFactory;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by talma07 on 12/28/2016.
 */

@RestController
@RequestMapping("api/v1/sharcle/")


public class SharcleController {


    @RequestMapping(value = "user", method = RequestMethod.GET)
    public User create(@RequestParam("displayName") String displayname, @RequestParam("email") String email,
                              @RequestParam("commercialUser") String commercialUser) {


        RegistrationService regService = ServiceFactory.getRegistrationService();

        User user = new User();
        user.setDisplayName(displayname);
        user.setCommType(commercialUser);
        user.setEmailId(email);
        user.setImagePath("imagePath");
        user.setUserCreatedTime(System.currentTimeMillis()+"");
        user.setUuid(UUID.randomUUID()+"");

        User regUser = regService.registerUser(user);
        return regUser;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        RegistrationService regService = ServiceFactory.getRegistrationService();
        //regService.g
        return regService.findUserByUUID(id+"");


    }

    @RequestMapping(value = "groups", method = RequestMethod.GET)
    public List<Group> getAvailableGroups(@RequestParam("longitude") String longitude, @RequestParam("lattitude") String lattitude) {

        GroupService grpService =ServiceFactory.getGroupService();
        return grpService.getGroupList(lattitude,longitude);
    }

    @RequestMapping(value = "groups/{groupId}/chat", method = RequestMethod.GET)
    public Boolean send(@PathVariable("groupId") String groupId, @RequestParam("userId") String userId, @RequestParam("message") String message) {

        ChatService cs =ServiceFactory.getChatService();
        Chat c = new Chat();
        c.setChatText(message);
        c.setGroupId(groupId);
        c.setTimeStamp(System.currentTimeMillis()+"");
        c.setUserId(userId);
        c.setUuid(UUID.randomUUID()+"");
        return cs.saveChat(c);
    }

    @RequestMapping(value = "groups/{groupId}/chats", method = RequestMethod.GET)
    public List<ChatDetails> getGroupChat(@PathVariable("groupId") String groupId) {
        ChatService cs =ServiceFactory.getChatService();
        return cs.getChatHistory(groupId);
    }

}
