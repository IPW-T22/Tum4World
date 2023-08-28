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
                    "descrizione VARCHAR(1024) NOT NULL," +
                    "immagine VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")"
            );
            conn.createStatement().executeUpdate("INSERT INTO " + TABELLA + " (titolo, descrizione, immagine) VALUES "+
                    "('Combattere la fame', 'Tum4Word ha fornito pasti alle persone che ne hanno bisogno. Grazie al suo lavoro, l''organizzazione è stata in grado di garantire che centinaia di bambini, in zone affette siccità e carestie, ricevessero almeno un pasto nutriente al giorno, migliorando la loro salute e il loro benessere. Inoltre, Tum4Word ha lavorato per promuovere l''agricoltura sostenibile e la sicurezza alimentare, aiutando le comunità a produrre cibo in modo sostenibile e a sviluppare una maggiore resilienza alle crisi alimentari.', 'images/food1.jpg'), " +
                    "('Programmi educativi', 'Tum4Word fornisce programmi educativi per bambini e adulti, con l''obiettivo di migliorare l''accesso all''istruzione e le opportunità di formazione, in zone povere. I programmi educativi di Tum4Word includono la costruzione di scuole, la formazione degli insegnanti, la fornitura di materiali didattici e la promozione dell''alfabetizzazione e dell''educazione sanitaria. Tum4Word ha lavorato a stretto contatto con i governi locali e le organizzazioni della società civile per garantire che i programmi educativi soddisfino le esigenze delle comunità servite e siano sostenibili a lungo termine.', 'images/school1.jpg'), " +
                    "('Supporto medico', 'Tum4Word si impegna a fornire supporto medico a coloro che ne hanno bisogno nei paesi in via di sviluppo. Grazie al suo lavoro, l''organizzazione è stata in grado di fornire cure mediche di base e specialistiche, Tum4Word ha fornito supporto psicologico e ha lavorato per prevenire e curare malattie come l''HIV / AIDS e la malaria. Tutti i programmi medici di Tum4Word sono stati sviluppati in collaborazione con i governi locali e gli operatori sanitari per garantire che soddisfino le esigenze specifiche delle comunità servite.', 'images/medicine1.jpg')"
            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
