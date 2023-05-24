package com.github.ipwt22.tum4world.models;

import com.github.ipwt22.tum4world.helpers.CitazioneHelper;
import com.github.ipwt22.tum4world.helpers.ContatoreHelper;
import com.github.ipwt22.tum4world.helpers.DatabaseHelper;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DB {
    private static final Connection conn;
    private static final Statement stmt;

    private static PreparedStatement prepStmt;

    static {
        try {
            conn = DatabaseHelper.getConnection();
           stmt = conn.createStatement();
            creaTabelle();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void creaTabelle() {
    }
    //settings per il database

    public static void signUp(String nome, String cognome, String email, String telefono, String username, String password, String dataDiNascita, int ruolo) {
        String sql = "INSERT INTO utenti (token, nome, cognome, email, telefono, username, password, data_di_nascita, ruolo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, "null");
            prepStmt.setString(2, nome);
            prepStmt.setString(3, cognome);
            prepStmt.setString(4, email);
            prepStmt.setString(5, telefono);
            prepStmt.setString(6, username);
            prepStmt.setString(7, password);
            prepStmt.setString(8, dataDiNascita);
            prepStmt.setInt(9, ruolo);
            prepStmt.executeUpdate();
            prepStmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static Utente getUtenteFromResultSet(ResultSet resultSet) throws SQLException {
        Utente user = null;
        if (resultSet.next()) { //se la query non ha restituito niente
            user = new Utente();
            Date dataDiNascita = null;
            try {
                dataDiNascita = new SimpleDateFormat("dd-MM-yyyy").parse(resultSet.getString("data_di_nascita"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            user.setNome(resultSet.getString("nome"));
            user.setCognome(resultSet.getString("cognome"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setRuolo(Utente.Ruolo.values()[resultSet.getInt("ruolo")]);
            user.setEmail(resultSet.getString("email"));
            user.setTelefono(resultSet.getString("telefono"));
            user.setDataDiNascita(dataDiNascita);
        }
        return user;
    }

    public static Utente getUserFromUsername(String username) {
        String sql = "SELECT * FROM Utenti WHERE username = ?";
        Utente user = null;
        try {
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, username);
            ResultSet resultSet = prepStmt.executeQuery();
            user = getUtenteFromResultSet(resultSet);
            prepStmt.close();
            resultSet.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
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
        String sql = "SELECT * FROM Utenti WHERE token = ?";
        Utente user = null;
        prepStmt = conn.prepareStatement(sql);
        prepStmt.setString(1, token);
        ResultSet resultSet = prepStmt.executeQuery();
        user = getUtenteFromResultSet(resultSet);
        prepStmt.close();
        resultSet.close();
        return user;
    }

    public static void setKeyOfUser(String username, String token) {
        String sql = "UPDATE Utenti SET token = ? WHERE username = ?";
        try {
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, token);
            prepStmt.setString(2, username);
            prepStmt.executeUpdate();
            prepStmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static Citazione getRandomCitazione() {
        String sql = "SELECT COUNT(*) FROM Citazioni";
        Random random = new Random();
        int numberOfRows = -1;
        int index;
        Citazione citazione = new Citazione();
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            resultSet.next();
            numberOfRows = resultSet.getInt(1);
            index = random.nextInt(numberOfRows);
            sql = "SELECT * FROM Citazioni";
            resultSet = stmt.executeQuery(sql);
            for(int i=1;i<=index;++i)
                resultSet.next();
            citazione.setTesto(resultSet.getString("testo"));
            citazione.setAutore(resultSet.getString("autore"));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
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
