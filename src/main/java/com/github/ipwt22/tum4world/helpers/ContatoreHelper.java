package com.github.ipwt22.tum4world.helpers;

import com.github.ipwt22.tum4world.models.Contatore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoreHelper {
    public static final String TABELLA = "contatori";
    public static Contatore fromResultSet(ResultSet rs) throws SQLException {
        Contatore c = new Contatore();
        c.setPercorso(rs.getString("percorso"));
        c.setVisite(rs.getInt("visite"));
        return c;
    }

    public static Contatore fromPercorso(Connection conn, String percorso) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM " + TABELLA + " WHERE percorso = ?");
            pstmt.setString(1, percorso);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return fromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Contatore> all(Connection conn) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + TABELLA);
            List<Contatore> contatori = new ArrayList<>();
            while (rs.next()) {
                Contatore c = fromResultSet(rs);
                contatori.add(c);
            }
            return contatori;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save(Connection conn, Contatore c) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE " + TABELLA + " SET visite = ? WHERE percorso = ?");
            pstmt.setInt(1, c.getVisite());
            pstmt.setString(2, c.getPercorso());
            int righe = pstmt.executeUpdate();
            if (righe == 0) {
                pstmt = conn.prepareStatement("INSERT INTO " + TABELLA + " (percorso, visite) VALUES (?, ?)");
                pstmt.setString(1, c.getPercorso());
                pstmt.setInt(2, c.getVisite());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INIZIALIZZAZIONE
    public static void init(Connection conn){
        try {
            conn.createStatement().executeUpdate("CREATE TABLE " + TABELLA + " (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "percorso VARCHAR(255) NOT NULL UNIQUE," +
                    "visite INTEGER NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void delete(Connection conn){
        try {
            conn.createStatement().executeUpdate("DROP TABLE " + TABELLA);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        init(conn);
    }
}
