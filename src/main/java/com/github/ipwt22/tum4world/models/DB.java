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


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
