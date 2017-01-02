package com.ca.services;

import com.ca.model.ChatOffer;
import com.ca.dao.ChatOfferDAO;
import com.ca.dao.ChatOfferDAOImpl;
import com.ca.model.ChatOfferDetails;

import java.util.List;

/**
 * Created by indka01 on 12/30/2016.
 */
public class OfferServiceImpl implements ChatOfferService {
    @Override
    public boolean saveOffer(ChatOffer chatOffer) {
        ChatOfferDAO chatDao = new ChatOfferDAOImpl();
        return chatDao.save(chatOffer);
    }

    @Override
    public List<ChatOfferDetails> getOffers(String groupId) {
        ChatOfferDAO chatDao = new ChatOfferDAOImpl();
        return chatDao.getOffers(groupId);
    }
}
