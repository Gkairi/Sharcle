package com.ca.innovate.controller;

import com.ca.dao.*;
import com.ca.innovate.controller.dummyData.SharcleData;
import com.ca.innovate.controller.model.GroupDetails;
import com.ca.innovate.controller.model.UserDetails;
import com.ca.model.*;
import com.ca.services.*;
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
        user.setUserCreatedTime(System.currentTimeMillis() + "");
        user.setUuid(UUID.randomUUID() + "");

        User regUser = regService.registerUser(user);
        return regUser;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        RegistrationService regService = ServiceFactory.getRegistrationService();
        //regService.g
        return regService.findUserByUUID(id + "");


    }

    @RequestMapping(value = "groups", method = RequestMethod.GET)
    public List<Group> getAvailableGroups(@RequestParam("longitude") String longitude, @RequestParam("lattitude") String lattitude) {

        GroupService grpService = ServiceFactory.getGroupService();
        return grpService.getGroupList(lattitude, longitude);
    }

    @RequestMapping(value = "groups/{groupId}/chat", method = RequestMethod.GET)
    public Boolean send(@PathVariable("groupId") String groupId, @RequestParam("userId") String userId, @RequestParam("message") String message) {

        ChatService cs = ServiceFactory.getChatService();
        Chat c = new Chat();
        c.setChatText(message);
        c.setGroupId(groupId);
        c.setTimeStamp(System.currentTimeMillis() + "");
        c.setUserId(userId);
        c.setUuid(UUID.randomUUID() + "");
        return cs.saveChat(c);
    }

    @RequestMapping(value = "groups/{groupId}/chats", method = RequestMethod.GET)
    public List<ChatDetails> getGroupChat(@PathVariable("groupId") String groupId) {
        ChatService cs = ServiceFactory.getChatService();
        return cs.getChatHistory(groupId);
    }

    @RequestMapping(value = "offers/chat/{groupId}", method = RequestMethod.GET)
    public List<ChatOffer> getChatOffers(@PathVariable("groupId") String groupId) {
        ChatOfferService cs = ServiceFactory.getChatOfferService();
        return cs.getOffers(groupId);
    }


    @RequestMapping(value = "offers/chat", method = RequestMethod.GET)
    public Boolean postChatOffer(@RequestParam("groupId") String groupId, @RequestParam("userId") String userId,
                                 @RequestParam("offerType") String offerType,
                                 @RequestParam("offerDesc") String offerDesc, @RequestParam("offerImgPath") String offerImgPath,
                                 @RequestParam("offerStartTime") String offerStartTime,
                                 @RequestParam("offerEndTime") String offerEndTime) {
        ChatOfferService cs = ServiceFactory.getChatOfferService();

        ChatOffer chatOffer = new ChatOffer();
        chatOffer.setUserId(userId);
        chatOffer.setGroupId(groupId);

        chatOffer.setUuid(UUID.randomUUID()+"");
        chatOffer.setOfferDesc(offerDesc);
        chatOffer.setOfferStartTime(offerStartTime);
        chatOffer.setOfferEndTime(offerEndTime);
        chatOffer.setOfferImgPath(offerImgPath);
        chatOffer.setOfferId(offerDesc.hashCode()+"");
        cs.saveOffer(chatOffer);
        return true;
    }

}
