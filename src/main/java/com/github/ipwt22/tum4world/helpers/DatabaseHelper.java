package com.github.ipwt22.tum4world.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    static Connection connection = null;

    public static Connection getConnection() {
        try {
            if(connection == null || connection.isClosed()) throw new Exception();
        } catch (Exception e) {
            connection = connetti();
        }
        return connection;
    }

    public static Connection connetti() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/tum4world", "App", "Password");
            init(conn);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void init(Connection conn){
        CitazioneHelper.init(conn);
        ContatoreHelper.init(conn);
    }
}
