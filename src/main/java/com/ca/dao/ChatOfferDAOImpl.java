package com.ca.dao;

import com.ca.model.ChatOffer;
import com.ca.model.ChatOfferDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by indka01 on 12/30/2016.
 */
public class ChatOfferDAOImpl implements ChatOfferDAO {

    private String INSERT = "INSERT INTO ChatOffer (UUID,Group_id,Offer_id,Offer_type,Description,Offer_Starttime,Offer_endtime,User_Id,Offer_image)\n" +
            "VALUES (?,?,?,?,?,?,?,?,?)";
    private String SELECT = "SELECT UUID, Group_id, Offer_id, Offer_type, Description, Offer_Starttime, Offer_endtime, User_Id,display_name, Offer_image \n" +
            "FROM SHARCLE.ChatOffer where group_id=? order by offer_starttime";

    private  String updateDisplay= "update ChatOffer set display_name= (select display_name FROM Registration where Registration.Email_id = ChatOffer.User_Id limit 1) where ChatOffer.User_Id =?";
    @Override
    public boolean save(ChatOffer chatOffer) {


        Connection conn = null;
        PreparedStatement stmt = null;
        String id= "";

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, chatOffer.getUuid());
            stmt.setString(2, chatOffer.getGroupId());
            stmt.setString(3, chatOffer.getOfferId());
            stmt.setString(4, chatOffer.getOfferType());
            stmt.setString(5, chatOffer.getOfferDesc());
            stmt.setString(6, chatOffer.getOfferStartTime());
            stmt.setString(7, chatOffer.getOfferEndTime());
            stmt.setString(8, chatOffer.getUserId());
            stmt.setString(9, chatOffer.getOfferImgPath());
            id = chatOffer.getUserId();

            int ret = stmt.executeUpdate();

            if (ret < 0) {
                return false;
            }

        } catch (SQLException e) {
             e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(stmt);
            DBUtils.close(conn);
        }

       return  updateDisplayName(id);
    }

    @Override
    public List<ChatOfferDetails> getOffers(String groupId) {
        List<ChatOfferDetails> chatOfferList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(SELECT);
            stmt.setString(1,groupId);

            ResultSet rs = stmt.executeQuery();
/*
        SELECT UUID, Group_id, Offer_id, Offer_type, Description, Offer_Starttime, Offer_endtime, User_Id, Offer_image
FROM SHARCLE.ChatOffer;
        */
            while (rs.next()) {
                ChatOfferDetails chatOffer = new ChatOfferDetails();
                chatOffer.setUuid(rs.getString("UUID"));
                chatOffer.setGroupId(rs.getString("Group_id"));
                chatOffer.setOfferId(rs.getString("Offer_id"));
                chatOffer.setOfferType(rs.getString("Offer_type"));
                chatOffer.setOfferDesc(rs.getString("Description"));
                chatOffer.setOfferStartTime(rs.getString("Offer_Starttime"));
                chatOffer.setOfferEndTime(rs.getString("Offer_endtime"));
                chatOffer.setUserId(rs.getString("User_Id"));
                chatOffer.setOfferImgPath(rs.getString("Offer_image"));
                chatOffer.setUserDisplayName(rs.getString("display_name"));
                System.out.println(chatOffer);
                chatOfferList.add(chatOffer);
            }
        } catch (SQLException e) {
             e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(stmt);
            DBUtils.close(conn);
        }
        return chatOfferList;
    }

    public boolean updateDisplayName(String user_Id)
    {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(updateDisplay);
            stmt.setString(1,user_Id);

            int ret = stmt.executeUpdate();

            if (ret < 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
             e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(stmt);
            DBUtils.close(conn);
        }

    }

}
