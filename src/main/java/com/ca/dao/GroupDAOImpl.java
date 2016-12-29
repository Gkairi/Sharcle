package com.ca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by indka01 on 12/29/2016.
 */
public class GroupDAOImpl implements GroupDAO {

    /*
  group table
  UUID varchar(254) NOT NULL,
Group_id varchar(254) NOT NULL,
Group_Name varchar(254) NOT NULL,
Group_address varchar(254),
GPS_Latitude varchar(254),
GPS_Longitude varchar(254),
Time_stamp long,
Type varchar(30),
   */
    String DELETE = "DELETE FROM groups WHERE groupid=?";

    String FINDBYGROUPID = "SELECT * FROM groups WHERE groupid=? ";
    String INSERT = "INSERT INTO TABLE groups(Group_id,Group_Name,Group_address,GPS_Latitude,GPS_Longitude,type,UUID) VALUES(?,?,?,?,?,?,?)";

    @Override
    public boolean save(Group group) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, group.getGroupId());
            stmt.setString(2, group.getGroupName());
            stmt.setString(3, group.getGroupAddress());
            stmt.setString(4, group.getGpsLatitude());
            stmt.setString(5, group.getGpsLongitude());
            stmt.setString(6, group.getType());
            stmt.setString(6,   UUID.randomUUID()+"");


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

    @Override
    public Group findByGroupId(String groupId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(FINDBYGROUPID);
            stmt.setString(1, groupId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Group grp = new Group();
                grp.setGpsLatitude(rs.getString("GPS_Latitude"));
                grp.setGpsLongitude(rs.getString("GPS_Longitude"));

                grp.setGroupAddress(rs.getString("Group_address"));
                grp.setGroupId(rs.getString("Group_id"));
                grp.setGroupName(rs.getString("Group_Name"));
                grp.setTimeStamp(rs.getString("commuser"));
                grp.setType(rs.getString("type"));
                grp.setUuid(rs.getString("uuid"));







                return grp;
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
    public boolean delete(Group group) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setString(1, group.getGroupId());

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
