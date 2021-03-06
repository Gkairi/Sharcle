package com.ca.dao;

import com.ca.model.Chat;
import com.ca.model.ChatDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by indka01 on 12/29/2016.
 */
public class ChatDAOImpl implements ChatDAO {
    /*
       UUID varchar(254) NOT NULL,
  Group_id varchar(254) NOT NULL,
  Chat_text varchar(254) NOT NULL,
  User_Id varchar(30) NOT NULL,
  Time_stamp long,
     */

    public String SAVE = "INSERT INTO Chat (UUID,Group_id,Chat_text,User_Id,Time_stamp)\n" +
            "VALUES (?,?,?,?,?);";
    /*public String GETCHATS ="SELECT UUID, Group_id, Chat_text, User_Id, Time_stamp \n" +
            "FROM Chat where Group_id =? order by Time_stamp";*/
    public String GETCHATS ="select email_id,display_name,Image,chat_text,user_id,Chat.Time_Stamp ,Chat.UUID ,Chat.Group_id from Chat ,Registration where Chat.user_id=Registration.email_id and Group_id =? order by Chat.Time_stamp ";
    @Override
    public boolean save(Chat chat) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(SAVE);
            stmt.setString(1, chat.getUuid());
            stmt.setString(2, chat.getGroupId());
            stmt.setString(3, chat.getChatText());
            stmt.setString(4, chat.getUserId());
            stmt.setString(5, System.currentTimeMillis()+"");


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

    @Override
    public List<ChatDetails> getChatLastOneHour(String groupId) {

        List<ChatDetails> chatList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;

        System.out.println("$$$$$$$$$$$$ getChatLastOneHour called with GroupId"+groupId );

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(GETCHATS);
            stmt.setString(1,groupId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ChatDetails chat = new ChatDetails();
                chat.setUuid(rs.getString("UUID"));
                chat.setGroupId(rs.getString("Group_id"));
                chat.setChatText(rs.getString("Chat_text"));
                chat.setUserId(rs.getString("User_Id"));
                chat.setTimeStamp(rs.getString("Time_stamp"));
                chat.setUserDisplayName(rs.getString("display_name"));
                System.out.println(chat);
                chatList.add(chat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        } finally {
            DBUtils.close(stmt);
            DBUtils.close(conn);
        }
        return chatList;
    }

    public static void main1 (String args[])
    {
        ChatDAO cd = new ChatDAOImpl();
        Chat c = new Chat();
        c.setChatText("hi");
        c.setGroupId("TestGroupId1");
        c.setTimeStamp(System.currentTimeMillis()+"");
        c.setUuid(UUID.randomUUID()+"");
        c.setUserId("userone");

     //   cd.save(c);
      //  List<Chat> lc = cd.getChatLastOneHour("TestGroupId1");

    }
}
