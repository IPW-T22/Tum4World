package com.github.ipwt22.tum4world.helpers;

import com.github.ipwt22.tum4world.models.Citazione;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitazioneHelper {
    public static final String TABELLA = "citazioni";
    public static Citazione fromResultSet(ResultSet rs) throws SQLException {
        Citazione citazione = new Citazione();
        citazione.setId(rs.getInt("id"));
        citazione.setTesto(rs.getString("testo"));
        citazione.setAutore(rs.getString("autore"));
        return citazione;
    }

    public static Citazione fromId(Connection conn, int id) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + TABELLA + " WHERE id = " + id);
            if (rs.next()) return fromResultSet(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Citazione random(Connection conn) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + TABELLA + " ORDER BY RANDOM() FETCH FIRST ROW ONLY");
            if (rs.next()) return fromResultSet(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static List<Citazione> all(Connection conn) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + TABELLA);
            List<Citazione> citazioni = new ArrayList<>();
            while (rs.next()) {
                Citazione c = fromResultSet(rs);
                citazioni.add(c);
            }
            return citazioni;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // INIZIALIZZAZIONE
    public static void init(Connection conn){
        try {
            conn.createStatement().executeUpdate("CREATE TABLE " + TABELLA + " (" +
                            "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                            "testo VARCHAR(255) NOT NULL," +
                            "autore VARCHAR(255) NOT NULL," +
                            "PRIMARY KEY (id)" +
                            ")");
            conn.createStatement().executeUpdate("INSERT INTO citazioni (testo, autore) VALUES " +
                    "('Il volontariato è l’arte di mettere il proprio cuore dove gli altri hanno bisogno di esso.', 'Autori vari'), " +
                    "('Il volontariato non è un lavoro pagato perché non ha prezzo.', 'Sherry Anderson'), " +
                    "('L’altruismo è la forma più elevata di autorealizzazione.', 'Ayn Rand'), " +
                    "('Non possiamo fare grandi cose sulla terra, solo piccole cose con grande amore.', 'Madre Teresa'), " +
                    "('La felicità non arriva mai da sola, a meno che non la si condivida con gli altri.', 'Helen Keller'), " +
                    "('Il vero significato della vita è trovare la propria vocazione nel servizio degli altri.', 'Albert Schweitzer'), " +
                    "('Il volontariato è l’opportunità di cambiare il mondo una persona alla volta.', 'Autori vari'), " +
                    "('Non possiamo aiutare tutti, ma tutti possono aiutare qualcuno.', 'Ronald Reagan'), " +
                    "('Il volontariato non è solo una parola, ma un’azione che può cambiare il mondo.', 'Autori vari'), " +
                    "('Il volontariato è l’arte di donare il proprio tempo e le proprie energie per migliorare la vita degli altri e della propria comunità.', 'Autori vari'), " +
                    "('Il volontariato è l’opportunità di fare la differenza nella vita degli altri e nella propria vita.', 'Autori vari'), " +
                    "('Il volontariato è l’opportunità di dare il proprio contributo alla società e alla propria comunità.', 'Autori vari'), " +
                    "('La felicità non è avere ciò che si desidera, ma desiderare ciò che si ha.', 'Dale Carnegie'), " +
                    "('L’unico modo per fare un grande lavoro è amare quello che fai.', 'Steve Jobs'), " +
                    "('La vita è un’opportunità, coglila.', 'Madre Teresa'), " +
                    "('Non c’è mai abbastanza tempo per fare tutto, ma c’è sempre abbastanza tempo per fare la cosa giusta.', 'Wesley Duewel'), " +
                    "('Il modo migliore per trovare se stessi è perdersi nel servizio degli altri.', 'Mahatma Gandhi'), " +
                    "('Fai del bene di nascosto e arrossisci a vederlo divulgato.', 'Seneca'), " +
                    "('Ogni uomo è colpevole di tutto il bene che non ha fatto.', 'Voltaire'), " +
                    "('Non basta fare del bene, bisogna anche farlo bene.', 'Denis Diderot')");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
