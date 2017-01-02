package com.ca.dao;

import com.ca.model.Group;

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
    String DELETE = "DELETE FROM Groups WHERE Group_id=? limit 3";

    String FINDBYGROUPID = "SELECT * FROM Groups WHERE Group_id=? ";
    String INSERT = "INSERT INTO  Groups(Group_id, Group_Name, Group_address, GPS_Latitude, GPS_Longitude, Time_stamp, Type ,UUID) VALUES(?,?,?,?,?,?,?,?)";

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
            stmt.setString(6,group.getTimeStamp());
            stmt.setString(7, group.getType());
            stmt.setString(8,   UUID.randomUUID()+"");


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
                /*
                Group_id, Group_Name, Group_address, GPS_Latitude, GPS_Longitude, Time_stamp, Type
                 */
                Group grp = new Group();
                grp.setGpsLatitude(rs.getString("GPS_Latitude"));
                grp.setGpsLongitude(rs.getString("GPS_Longitude"));

                grp.setGroupAddress(rs.getString("Group_address"));
                grp.setGroupId(rs.getString("Group_id"));
                grp.setGroupName(rs.getString("Group_Name"));
                grp.setTimeStamp(rs.getString("Time_stamp"));
                grp.setType(rs.getString("Type"));
                grp.setUuid(rs.getString("UUID"));


                return grp;
            } else {
                return null;
            }
        } catch (SQLException e) {
             e.printStackTrace();
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

    public static void main1(String args[])
    {
        Group g = new Group();
        g.setGpsLatitude("1");
        g.setGpsLongitude("1long");
        g.setGroupAddress("add");
        g.setGroupId("grpid1");
        g.setGroupName("grpName");
        g.setTimeStamp(System.currentTimeMillis()+"");
        g.setType("t");
        g.setUuid(UUID.randomUUID()+"");
        GroupDAO gdao = new GroupDAOImpl();

        gdao.save(g);
        gdao.findByGroupId("grpid1");
        gdao.delete(g);


    }

}
