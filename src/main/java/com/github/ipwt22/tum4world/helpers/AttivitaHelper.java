package com.github.ipwt22.tum4world.helpers;

import java.sql.Connection;
import java.sql.SQLException;

public class AttivitaHelper {
    public static final String TABELLA = "attivita";
    public static void init(Connection conn) {
        try {
            conn.createStatement().executeUpdate("CREATE TABLE " + TABELLA + " (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "titolo VARCHAR(255) NOT NULL," +
                    "descrizione VARCHAR(255) NOT NULL," +
                    "immagine VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")"
            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
