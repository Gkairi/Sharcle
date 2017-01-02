package com.ca.dao;

import com.ca.model.ChatOffer;
import com.ca.model.ChatOfferDetails;

import java.util.List;

/**
 * Created by indka01 on 12/30/2016.
 */
public interface ChatOfferDAO {

    public boolean save(ChatOffer chatOffer);
    public List<ChatOfferDetails> getOffers(String groupId);
}
