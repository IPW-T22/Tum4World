package com.github.ipwt22.tum4world.helpers;

import java.sql.Connection;
import java.sql.SQLException;

public class DonazioneHelper {
    public static final String TABELLA = "donazioni";
    public static void init(Connection conn) {
        try {
            conn.createStatement().executeUpdate("CREATE TABLE " + TABELLA + " (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "username VARCHAR(255) NOT NULL," +
                    "importo DECIMAL(10,2) NOT NULL," +
                    "data DATE NOT NULL," +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (username) REFERENCES " + UtenteHelper.TABELLA + "(username)" +
                    ")");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
