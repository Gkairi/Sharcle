package com.ca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by indka01 on 12/28/2016.
 */
public class UserDAOImpl implements UserDAO {
    String DELETE = "DELETE FROM registration WHERE emailId=?";

    String FINDBYEMAILID = "SELECT * FROM registration WHERE emailId=? ";
    String INSERT = "INSERT INTO TABLE registration(UUID,EMAIL_ID,DISPLAY_NAME,COMM_USER,IMAGE,TIMESTAMP) VALUES(?,?,?,?,?,?)";

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
                user.setEmailId(rs.getString("emailid"));
                user.setCommType(rs.getString("commuser"));
                user.setDisplayName(rs.getString("displayname"));
                user.setUuid(rs.getString("uuid"));
                user.setUserCreatedTime(
                        rs.getLong("time_stamp")
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
}
