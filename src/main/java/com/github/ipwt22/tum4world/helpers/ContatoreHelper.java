package com.github.ipwt22.tum4world.helpers;

import com.github.ipwt22.tum4world.models.Contatore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoreHelper {
    public static final String TABELLA = "contatori";
    public static Contatore fromResultSet(ResultSet rs) throws SQLException {
        Contatore c = new Contatore();
        c.setId(rs.getInt("id"));
        c.setPercorso(rs.getString("percorso"));
        c.setVisite(rs.getInt("visite"));
        return c;
    }

    public static Contatore fromId(Connection conn, int id)  {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + TABELLA + " WHERE id = " + id);
            if (rs.next()) return fromResultSet(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Contatore fromPercorso(Connection conn, String percorso) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + TABELLA + " WHERE percorso = '" + percorso + "'");
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

    public static void sendToDatabase(Connection conn, Contatore c) {
        try {
            int righe = conn.createStatement().executeUpdate("UPDATE " + TABELLA + " SET visite = " + c.getVisite() + " WHERE id = " + c.getId());
            if (righe == 0) {
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + TABELLA + " (percorso, visite) VALUES (?, ?)");
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
            conn.createStatement().executeUpdate("CREATE TABLE contatore (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "percorso VARCHAR(255) NOT NULL UNIQUE," +
                    "visite INTEGER NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
