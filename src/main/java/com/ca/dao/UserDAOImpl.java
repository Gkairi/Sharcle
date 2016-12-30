package com.ca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by indka01 on 12/28/2016.
 */
public class UserDAOImpl implements UserDAO {
    String DELETE = "DELETE FROM Registration WHERE Email_iD=?";

    String FINDBYEMAILID = "SELECT * FROM Registration WHERE Email_iD=? ";
    String FINDBYUUID="SELECT * FROM Registration WHERE uuid=? ";
    String INSERT = "INSERT INTO  Registration(UUID, Email_id, Display_name, Comm_user, Image, Time_stamp) VALUES(?,?,?,?,?,?)";

    public boolean save(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, user.getUuid());
            stmt.setString(2, user.getEmailId());
            stmt.setString(3, user.getDisplayName());
            stmt.setString(4, user.getCommType());
            stmt.setString(5, user.getImagePath());
            stmt.setLong(6, System.currentTimeMillis());


            int ret = stmt.executeUpdate();

            if (ret < 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(stmt);
            DBUtils.close(conn);
        }
    }


    public User findByEmailID(String emailId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(FINDBYEMAILID);
            stmt.setString(1, emailId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setEmailId(rs.getString("Email_iD"));
                user.setCommType(rs.getString("Comm_user"));
                user.setDisplayName(rs.getString("Display_name"));
                user.setUuid(rs.getString("uuid"));
                user.setUserCreatedTime(
                        rs.getString("time_stamp")
                );
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(stmt);
            DBUtils.close(conn);
        }
    }

    @Override
    public User findByUUID(String uuid) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(FINDBYUUID);
            stmt.setString(1, uuid);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setEmailId(rs.getString("Email_iD"));
                user.setCommType(rs.getString("Comm_user"));
                user.setDisplayName(rs.getString("Display_name"));
                user.setUuid(rs.getString("uuid"));
                user.setUserCreatedTime(
                        rs.getString("time_stamp")
                );
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(stmt);
            DBUtils.close(conn);
        }
    }

    public boolean delete(User user) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setString(1, user.getEmailId());

            int ret = stmt.executeUpdate();
            if (ret < 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(stmt);
            DBUtils.close(conn);
        }
    }


    public static void main1(String args[])
    {
        UserDAO d = new UserDAOImpl();
        //d.findByEmailID("abc@gmail.com");

        User s = new User();
        s.setCommType("false");
        s.setDisplayName("asdf");
        s.setEmailId("1@gmail.com");
        s.setImagePath("asdf");
        s.setUserCreatedTime(System.currentTimeMillis()+"");
        s.setUuid(UUID.randomUUID()+"");
        //d.save(s);

        d.delete(s);

    }
}
