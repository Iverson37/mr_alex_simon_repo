package com.company.Data.connection;

import com.company.Main;

/**
 * Created by semen on 08.10.2015.
 */
public class ConncetionSettings {

    private static final String user = "root";
    private static final String password="root";
    private static final String url = "jdbc:mysql://localhost:3306/"+ Main.DATABASE_NAME;
    private static final String driver = "com.mysql.jdbc.Driver";

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUrl() {
        return url;
    }

    public static String getDriver() {
        return driver;
    }


}
