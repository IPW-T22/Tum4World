package com.github.ipwt22.tum4world.helpers;

import java.sql.Connection;
import java.sql.SQLException;

public class IscrizioneHelper {
    public static final String TABELLA = "iscrizioni";
    public static void init(Connection conn) {
        try {
            conn.createStatement().executeUpdate("CREATE TABLE " + TABELLA +" (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "username VARCHAR(255) NOT NULL," +
                    "attivita_id INTEGER NOT NULL," +
                    "PRIMARY KEY (username, attivita_id)," +
                    "FOREIGN KEY (username) REFERENCES " + UtenteHelper.TABELLA + "(username)," +
                    "FOREIGN KEY (attivita_id) REFERENCES " + AttivitaHelper.TABELLA + "(id)" +
                    ")"
            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
