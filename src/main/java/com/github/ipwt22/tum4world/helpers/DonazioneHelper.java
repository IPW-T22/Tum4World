package com.github.ipwt22.tum4world.helpers;

import com.github.ipwt22.tum4world.models.Utente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DonazioneHelper {
    public static final String TABELLA = "donazioni";
    public static void init(Connection conn) {
        try {
            conn.createStatement().executeUpdate("CREATE TABLE " + TABELLA + " (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "username VARCHAR(255) NOT NULL," +
                    "importo DECIMAL(10,2) NOT NULL," +
                    "data TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (username) REFERENCES " + UtenteHelper.TABELLA + "(username)" +
                    ")");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void aggiungiDonazione(Connection conn, Utente utente, double amount){
        try {
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO " + TABELLA + " (username, importo) VALUES ( ?, ?)");
            prepStmt.setString(1, utente.getUsername());
            prepStmt.setDouble(2, amount);
            prepStmt.executeUpdate();
            prepStmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
