package com.ca.services;

import com.ca.dao.ChatOffer;

import java.util.List;

/**
 * Created by indka01 on 12/30/2016.
 */
public interface ChatOfferService {
    public boolean saveOffer(ChatOffer chatOffer);
    public List<ChatOffer> getOffers(String groupId);
}
