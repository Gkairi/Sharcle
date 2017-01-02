package com.ca.services;

import com.ca.model.ChatOffer;
import com.ca.model.ChatOfferDetails;

import java.util.List;

/**
 * Created by indka01 on 12/30/2016.
 */
public interface ChatOfferService {
    public boolean saveOffer(ChatOffer chatOffer);
    public List<ChatOfferDetails> getOffers(String groupId);
}
