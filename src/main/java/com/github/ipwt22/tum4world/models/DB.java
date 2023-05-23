package com.github.ipwt22.tum4world.models;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DB {
    private static final Connection conn;
    private static final Statement stmt;

    private static PreparedStatement prepStmt;

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
                    "token VARCHAR(255) NOT NULL," +
                    "nome VARCHAR(255) NOT NULL," +
                    "cognome VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "telefono VARCHAR(255) NOT NULL," +
                    "username VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL," +
                    "data_di_nascita VARCHAR(255) NOT NULL," +
                    "ruolo INTEGER NOT NULL," +
                    "PRIMARY KEY (username)" +
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
    }
    //settings per il database

    public static boolean signUp(Utente user) {

        return true;
    }

    private static void setUtenteFromResultSet(Utente user, ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) { //se la query non ha restituito niente
            Date dataDiNascita = null;
            try {
                dataDiNascita = new SimpleDateFormat("dd-MM-yyyy").parse(resultSet.getString("dataDiNascita"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            user.setNome(resultSet.getString("nome"));
            user.setCognome(resultSet.getString("cognome"));
            user.setUsername(resultSet.getString("username"));
            user.setHashPassword(resultSet.getString("password"));
            user.setRuolo(Utente.Ruolo.values()[resultSet.getInt("ruolo")]);
            user.setEmail(resultSet.getString("email"));
            user.setTelefono(resultSet.getString("telefono"));
            user.setDataDiNascita(dataDiNascita);
        }
    }

    public static Utente getUserFromUsername(String username) {
        String sql = "SELECT * FROM Utenti WHERE username = ?;";
        Utente user = null;
        try {
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, username);
            ResultSet resultSet = prepStmt.executeQuery();
            setUtenteFromResultSet(user, resultSet);
            prepStmt.close();
            resultSet.close();
        }
        catch (SQLException e){}
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
        String sql = "SELECT * FROM Utenti WHERE token = ?;";
        Utente user = null;
        prepStmt = conn.prepareStatement(sql);
        prepStmt.setString(1, token);
        ResultSet resultSet = prepStmt.executeQuery();
        setUtenteFromResultSet(user, resultSet);
        prepStmt.close();
        resultSet.close();
        return user;
    }

    public static boolean setKeyOfUser(String username, String token) {
        String sql = "UPDATE Utenti SET token = ? WHERE username = ?;";
        try {
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, token);
            prepStmt.setString(2, username);
            prepStmt.executeQuery();
            prepStmt.close();
        }
        catch (SQLException e){}
        return true;
    }


    public static Citazione getRandomCitazione() {
        String sql = "SELECT * FROM Citazioni ORDER BY RAND() LIMIT 1;";
        Citazione citazione = new Citazione();
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            citazione.setCitazione(resultSet.getString("citazione"));
        }
        catch (SQLException e){}
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

    /**
     * Preleva tutte le donazioni
     *
     * @return lista di donazioni
     */
    public static List<Donazione> getDonazioni() {
        List<Donazione> donazioni = new ArrayList<>();
        String sql = "SELECT * FROM Donazioni;";
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                Donazione donazione = new Donazione();
                donazione.setImporto(resultSet.getDouble("importo"));
                donazione.setData(resultSet.getDate("data"));
                donazioni.add(donazione);
            }
        }
        catch (SQLException e){}
        return donazioni;
    }

    public static List<Utente> getUtenti(){
        return null;
    }

    public static void addDonation(Utente utente, int amount) {
        // TODO: fai la donazione
    }
}
