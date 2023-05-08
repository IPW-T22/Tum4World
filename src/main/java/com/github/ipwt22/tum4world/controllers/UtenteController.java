package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.models.Attivita;
import com.github.ipwt22.tum4world.models.Utente;

import java.util.Date;

public class UtenteController {
    /**
     * Verifica se l'utente è iscritto all'attività.
     * @param utente
     * @param attivita
     * @return true se l'utente è iscritto all'attività, false altrimenti
     */
    public static boolean iscritto(Utente utente, Attivita attivita) {
        // TODO: implementare il metodo
        return true;
    }

    /**
     * Ottiene l'utente a partire dal token.
     * @param token
     * @return Utente associato al token
     */
    public static Utente risolvi(String token) throws Exception {
        // TODO: implementare il metodo
        Utente utente = new Utente();
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setEmail("mario.rossi@esempio.com");
        utente.setTelefono("0123456789");
        utente.setUsername("mario.rossi");
        utente.setDataDiNascita(new Date());
        utente.setRuolo(Utente.Ruolo.AMMINISTRATORE);
        return utente;
        // throw new Exception("Utente non trovato");
    }
}
