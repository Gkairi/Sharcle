package com.ca.dao;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by indka01 on 12/28/2016.
 */
public class DBUtils {

    public static void close(Connection con)
    {
        try {


            if (con != null) {
                con.close();
            }
        } catch (Exception e) {

        }
    }

    public static void close(Statement stmt)
    {
        try {


            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {

        }
    }
}
