package com.github.ipwt22.tum4world.helpers;

import com.github.ipwt22.tum4world.models.Contatore;
import com.github.ipwt22.tum4world.models.Iscrizione;
import com.github.ipwt22.tum4world.models.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IscrizioneHelper {
    public static final String TABELLA = "iscrizioni";
    public static void init(Connection conn) {
        try {
            conn.createStatement().executeUpdate("CREATE TABLE " + TABELLA +" (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "username VARCHAR(255) NOT NULL," +
                    "attivita_id INTEGER NOT NULL," +
                    "PRIMARY KEY (username, attivita_id)," +
                    "FOREIGN KEY (username) REFERENCES " + UtenteHelper.TABELLA + "(username) ON DELETE CASCADE," +
                    "FOREIGN KEY (attivita_id) REFERENCES " + AttivitaHelper.TABELLA + "(id)" +
                    ")"
            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void save(Connection conn, Iscrizione i, boolean add) {
        try {
            PreparedStatement pstmt;
            System.out.println("INSERT INTO iscrizioni (username, attivita_id) VALUES(" + i.getUsername() + ", " + i.getAttivita_id()+")");
            if (add)
                pstmt = conn.prepareStatement("INSERT INTO " + TABELLA + " (username, attivita_id) VALUES (?, ?)");
            else
                pstmt = conn.prepareStatement("DELETE FROM " + TABELLA + " WHERE username = ? AND attivita_id = ?");
            pstmt.setString(1, i.getUsername());
            pstmt.setInt(2, i.getAttivita_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Iscrizione fromResultSet(ResultSet rs) throws SQLException {
        Iscrizione iscrizione = new Iscrizione();
        iscrizione.setId(rs.getInt("id"));
        iscrizione.setUsername(rs.getString("username"));
        iscrizione.setAttivita_id(rs.getInt("attivita_id"));
        return iscrizione;
    }
    public static List<Iscrizione> fromUtente(Connection conn, Utente utente) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM " + TABELLA + " WHERE username = ?");
            pstmt.setString(1, utente.getUsername());
            ResultSet rs = pstmt.executeQuery();
            List<Iscrizione> iscrizioni = new ArrayList<>();
            while (rs.next()) {
                Iscrizione iscrizione = fromResultSet(rs);
                iscrizioni.add(iscrizione);
            }
            return iscrizioni;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
