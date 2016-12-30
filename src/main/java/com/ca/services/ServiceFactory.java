package com.ca.services;

/**
 * Created by indka01 on 12/30/2016.
 */
public class ServiceFactory {

    private static ChatService chatService;
    private static GroupService groupService;
    private static ChatOfferService chatOfferService;
    private static RegistrationService registrationService;

    public static ChatService getChatService() {
        if (chatService == null) {
            chatService = new ChatServiceImpl();
        }
        return chatService;
    }

    public static GroupService getGroupService() {
        if (groupService == null) {
            groupService = new GroupServiceImpl();
        }
        return groupService;
    }

    public static ChatOfferService getChatOfferService() {
        if (chatOfferService == null) {
            chatOfferService = new OfferServiceImpl();
        }
        return chatOfferService;
    }

    public static RegistrationService getRegistrationService() {
        if (registrationService == null) {
            registrationService = new RegistrationServiceImpl();
        }
        return registrationService;
    }
}
