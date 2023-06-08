package com.github.ipwt22.tum4world.helpers;

import com.github.ipwt22.tum4world.models.Contatore;
import com.github.ipwt22.tum4world.models.Donazione;
import com.github.ipwt22.tum4world.models.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonazioneHelper {
    public static final String TABELLA = "donazioni";
    public static void init(Connection conn) {
        try {
            conn.createStatement().executeUpdate("CREATE TABLE " + TABELLA + " (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "username VARCHAR(255) ," +
                    "importo DECIMAL(10,2) NOT NULL," +
                    "data TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (username) REFERENCES " + UtenteHelper.TABELLA + "(username) ON DELETE SET NULL" +
                    ")");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Donazione fromResultSet(ResultSet rs) throws SQLException {
        Donazione d = new Donazione();
        d.setId(rs.getInt("id"));
        Utente utente = UtenteHelper.fromUsername(DatabaseHelper.getConnection(),rs.getString("username"));
        d.setUtente(utente);
        d.setImporto(rs.getDouble("importo"));
        d.setData(rs.getTimestamp("data"));
        return d;
    }

    public static List<Donazione> all(Connection conn) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + TABELLA);
            List<Donazione> donazioni = new ArrayList<>();
            while (rs.next()) {
                Donazione d = fromResultSet(rs);
                donazioni.add(d);
            }
            return donazioni;
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
