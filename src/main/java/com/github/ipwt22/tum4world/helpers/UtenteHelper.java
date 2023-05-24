package com.github.ipwt22.tum4world.helpers;

import com.github.ipwt22.tum4world.models.Citazione;
import com.github.ipwt22.tum4world.models.Utente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteHelper {
    public static final String TABELLA = "utenti";

    public static Utente fromResultSet(ResultSet rs) throws SQLException {
        Utente utente = new Utente();
        utente.setToken(rs.getString("token"));
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

    public static Utente fromToken(Connection conn, String token){
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM " + TABELLA + " WHERE token = '" + token + "'");
            if (rs.next()) return fromResultSet(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // INIZIALIZZAZIONE
    public static void init(Connection conn){
        try {
            conn.createStatement().executeUpdate("CREATE TABLE utenti (" +
                    "nome VARCHAR(255) NOT NULL," +
                    "cognome VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "telefono VARCHAR(255) NOT NULL," +
                    "username VARCHAR(255) NOT NULL ," +
                    "password VARCHAR(255) NOT NULL," +
                    "data_di_nascita VARCHAR(255) NOT NULL," +
                    "ruolo VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (username)" +
                    ")");

            conn.createStatement().executeUpdate("INSERT INTO utenti (nome, cognome, email, telefono, username, password, data_di_nascita, ruolo) VALUES " +
                    "('PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'admin', '22Adm1n!', '29-10-2022', 'AMMINISTRATORE')," +
                    "('PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'simpatizzante', 'simpatizzante', '29-10-2022', 'SIMPATIZZANTE')," +
                    "('PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'aderente', 'aderente', '29-10-2022', 'ADERENTE')," +
                    "('PippoAdmin', 'PaperinoAdmin', 'pincopallino@gmail2023.com', '39219828172', 'amministratore', 'amministratore', '29-10-2022', 'AMMINISTRATORE')"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
