package com.github.ipwt22.tum4world.helpers;

import com.github.ipwt22.tum4world.models.Utente;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UtenteHelper {
    public static final String TABELLA = "utenti";
    public static final String TABELLA_SESSIONI = "sessioni";
    public static Utente fromResultSet(ResultSet rs) throws SQLException {
        Utente utente = new Utente();
        utente.setNome(rs.getString("nome"));
        utente.setCognome(rs.getString("cognome"));
        utente.setEmail(rs.getString("email"));
        utente.setTelefono(rs.getString("telefono"));
        utente.setPassword(rs.getString("password"));
        utente.setUsername(rs.getString("username"));
        utente.setDataDiNascita(rs.getDate("data_di_nascita"));
        utente.setRuolo(Utente.Ruolo.valueOf(rs.getString("ruolo")));

        return utente;
    }

    public static boolean deleteFromUsername(Connection conn, String username){
        try {
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM " + TABELLA + " WHERE username=?");
            pstm.setString(1, username);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Utente> all(Connection conn){
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + TABELLA);
            List<Utente> utenti = new ArrayList<>();
            while (rs.next()) {
                Utente utente = fromResultSet(rs);
                utenti.add(utente);
            }
            return utenti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Utente fromUsername(Connection conn, String username){
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM " + TABELLA + " WHERE username=?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return fromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Utente fromToken(Connection conn, String token){
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM " + TABELLA_SESSIONI + " WHERE token=?");
            pstmt.setString(1, token);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return fromUsername(conn, rs.getString("username"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setKeyOf(Connection conn, String username, String token){
        try {
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO " + TABELLA_SESSIONI + " (token, username) VALUES(?, ?)");
            prepStmt.setString(1, token);
            prepStmt.setString(2, username);
            prepStmt.executeUpdate();
            prepStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTokenOfUsername(Connection conn, String username, String token){
        try {
            PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM " + TABELLA_SESSIONI + " WHERE token=? AND username=?");
            prepStmt.setString(1, token);
            prepStmt.setString(2, username);
            prepStmt.executeUpdate();
            prepStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INIZIALIZZAZIONE
    public static void init(Connection conn){
        try {
            conn.createStatement().executeUpdate("CREATE TABLE " + TABELLA + " (" +
                    "nome VARCHAR(255) NOT NULL," +
                    "cognome VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "telefono VARCHAR(255) NOT NULL," +
                    "username VARCHAR(255) NOT NULL ," +
                    "password VARCHAR(255) NOT NULL," +
                    "data_di_nascita DATE NOT NULL," +
                    "ruolo VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (username)" +
                    ")");

            conn.createStatement().executeUpdate("CREATE TABLE " + TABELLA_SESSIONI + " ("+
                    "token VARCHAR(255) NOT NULL," +
                    "username VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (token)," +
                    "FOREIGN KEY (username) REFERENCES " + TABELLA + "(username)" +
                    "ON DELETE CASCADE )"
            );

            conn.createStatement().executeUpdate("INSERT INTO " + TABELLA + " (nome, cognome, email, telefono, username, password, data_di_nascita, ruolo) VALUES " +
                    "('PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'admin', '22Adm1n!', '2022-10-20', 'AMMINISTRATORE')," +
                    "('PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'simpatizzante', 'simpatizzante', '2022-10-20', 'SIMPATIZZANTE')," +
                    "('PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'aderente', 'aderente', '2022-10-20', 'ADERENTE')," +
                    "('PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'amministratore', 'amministratore', '2022-10-20', 'AMMINISTRATORE')"
            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String get_value_from_cookie(String name, HttpServletRequest request){
        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                String nameCookie = c.getName();
                if(nameCookie.equals(name)){
                    return c.getValue();
                }
            }
        }
        return null;
    }

    public static String generateUniqueToken(String username) {
        UUID uuid = UUID.randomUUID();
        return username + ":" + uuid.toString();
    }

    public static void registerUser(Connection conn, Utente user) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO " + TABELLA + " (nome, cognome, email, telefono, username, password, data_di_nascita, ruolo) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)");
            prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getCognome());
            prepStmt.setString(3, user.getEmail());
            prepStmt.setString(4, user.getTelefono());
            prepStmt.setString(5, user.getUsername());
            prepStmt.setString(6, user.getPassword());
            prepStmt.setDate(7, new java.sql.Date(user.getDataDiNascita().getTime()));
            prepStmt.setString(8, user.getRuolo().toString());
            prepStmt.executeUpdate();
            prepStmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
