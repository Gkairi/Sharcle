package com.ca.dao;

/**
 * Created by indka01 on 12/28/2016.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //static reference to itself
    private static ConnectionFactory instance = new ConnectionFactory();
    public static final String URL = "jdbc:mysql://patgo02-I188008/SHARCLE?user=root&password=Root@123";
   // public static final String USER = "root";
    //public static final String PASSWORD = " Root@123";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    private static Connection connection = null;

    //private constructor
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {


        try {
            connection = DriverManager.getConnection(URL/*, USER, PASSWORD*/);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }
}