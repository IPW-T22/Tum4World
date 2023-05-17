package com.github.ipwt22.tum4world.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DB {
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
