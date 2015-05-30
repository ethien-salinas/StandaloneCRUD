package com.ethien.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfiguration {
	
    public static final String URL = "jdbc:hsqldb:mem:.";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";
    public static final String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
 
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("");
        	e.printStackTrace();
        }catch (Exception e) {
        	e.printStackTrace();
		}
        return connection;
    }
 
}