package com.github.ipwt22.tum4world.helpers;

import com.github.ipwt22.tum4world.models.Attivita;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttivitaHelper {
    public static final String TABELLA = "attivita";

    public static Attivita fromResultSet(ResultSet rs) throws SQLException {
        Attivita attivita = new Attivita();
        attivita.setId(rs.getInt("id"));
        attivita.setTitolo(rs.getString("titolo"));
        attivita.setDescrizione(rs.getString("descrizione"));
        attivita.setImmagine(rs.getString("immagine"));
        return attivita;
    }

    public static List<Attivita> all(Connection conn){
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + TABELLA);
            List<Attivita> attivitas = new ArrayList<>();
            while (rs.next()) {
                Attivita attivita = fromResultSet(rs);
                attivitas.add(attivita);
            }
            return attivitas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
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
            conn.createStatement().executeUpdate("INSERT INTO " + TABELLA + " (titolo, descrizione, immagine) VALUES "+
                    "('Cinema', 'Guarda un film al cinema', 'cinema.jpg'), " +
                    "('Teatro', 'Guarda uno spettacolo al teatro', 'teatro.jpg'), " +
                    "('Museo', 'Visita un museo', 'museo.jpg')"
            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
