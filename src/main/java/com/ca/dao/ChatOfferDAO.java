package com.ca.dao;

import java.util.List;

/**
 * Created by indka01 on 12/30/2016.
 */
public interface ChatOfferDAO {

    public boolean save(ChatOffer chatOffer);
    public List<ChatOffer> getOffers(String groupId);
}
