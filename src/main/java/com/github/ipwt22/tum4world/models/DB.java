package com.github.ipwt22.tum4world.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DB {
    private static Connection conn;
    private static Statement stmt;

    static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/tum4world", "App", "Password");
            stmt = conn.createStatement();

            creaTabelle();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void creaTabelle() {
        try {
            stmt.executeUpdate("CREATE TABLE utenti (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "nome VARCHAR(255) NOT NULL," +
                    "cognome VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "telefono VARCHAR(255) NOT NULL," +
                    "username VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL," +
                    "data_di_nascita DATE NOT NULL," +
                    "ruolo VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (id)," +
                    "UNIQUE (username)" +
                    ")");
        } catch (SQLException ignored) {
        }
        try {
            stmt.executeUpdate("CREATE TABLE citazioni (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "testo VARCHAR(255) NOT NULL," +
                    "autore VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")");
        } catch (SQLException ignored) {
        }
        try {
            stmt.executeUpdate("CREATE TABLE attivita (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "titolo VARCHAR(255) NOT NULL," +
                    "descrizione VARCHAR(255) NOT NULL," +
                    "immagine VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")");
        } catch (SQLException ignored) {
        }
        try {
            stmt.executeUpdate("CREATE TABLE iscrizioni (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "utente_id INTEGER NOT NULL," +
                    "attivita_id INTEGER NOT NULL," +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (utente_id) REFERENCES utenti(id)," +
                    "FOREIGN KEY (attivita_id) REFERENCES attivita(id)" +
                    ")");
        } catch (SQLException ignored) {
        }
        try {
            stmt.executeUpdate("CREATE TABLE donazioni (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "utente_id INTEGER NOT NULL," +
                    "importo DECIMAL(10,2) NOT NULL," +
                    "data DATE NOT NULL," +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (utente_id) REFERENCES utenti(id)" +
                    ")");
        } catch (SQLException ignored) {
        }
        try {
            stmt.executeUpdate("CREATE TABLE contatore (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "url VARCHAR(255) NOT NULL," +
                    "visite INTEGER NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")");
        } catch (SQLException ignored) {
        }
        try {
            stmt.executeUpdate("CREATE TABLE token (" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "utente_id INTEGER NOT NULL," +
                    "token VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (utente_id) REFERENCES utenti(id)" +
                    ")");
        } catch (SQLException ignored) {
        }

    }
    //settings per il database

    public static boolean signUp(Utente user) {

        return true;
    }

    public static Utente getUserFromUsername(String username) {
        Utente user = new Utente();

        return user;
    }

    /**
     * Ottiene l'utente a partire dal token.
     *
     * @param token
     * @return Utente associato al token
     */
    public static Utente getUserFromToken(String token) throws Exception {
        if (token == null) throw new Exception("token is null");

        Utente utente = new Utente();
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setEmail("mario.rossi@esempio.com");
        utente.setTelefono("0123456789");
        utente.setUsername("mario.rossi");
        utente.setDataDiNascita(new Date());
        utente.setRuolo(Utente.Ruolo.AMMINISTRATORE);

        return utente;
    }

    public static boolean setKeyOfUser(String username, String key) {

        return true;
    }


    public static Citazione getRandomCitazione() {
        Citazione citazione = new Citazione();
        citazione.setCitazione("LASCIATE OGNI SPERANZA A VOI CHE ENTRATE");
        return citazione;
    }

    /**
     * Verifica se l'utente è iscritto all'attività.
     *
     * @param utente
     * @param attivita
     * @return true se l'utente è iscritto all'attività, false altrimenti
     */
    public static boolean iscritto(Utente utente, Attivita attivita) {
        return true;
    }

    public static List<Donazione> getDonazioni() {
        return new ArrayList<>();
    }

    public static void addDonation(Utente utente, int amount) {
        // TODO: fai la donazione
    }
}
