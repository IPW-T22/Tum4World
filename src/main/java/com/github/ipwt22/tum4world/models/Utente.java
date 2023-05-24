package com.github.ipwt22.tum4world.models;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utente implements Serializable {

    public enum Ruolo {
        SIMPATIZZANTE,
        ADERENTE,
        AMMINISTRATORE
    }
    private String nome = "null";
    private String cognome = "null";
    private Date dataDiNascita = null;
    private String email = "null";
    private String telefono = "null";
    private Ruolo ruolo = Ruolo.SIMPATIZZANTE;

    private String username = "null";
    private String password = "null";

    public Utente() {
    }

    public Utente(String nome, String cognome, Date dataDiNascita, String email, String telefono, Ruolo ruolo, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.telefono = telefono;
        this.ruolo = ruolo;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String nome, String cognome, String email, String telefono, String username, String password, String dataDiNascita, Utente.Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.ruolo = ruolo;
        this.username = username;
        try {
            this.dataDiNascita = new SimpleDateFormat("dd-MM-yyyy").parse(dataDiNascita);
        }catch (ParseException e){
            e.printStackTrace();
        }
        this.password = password;
    }
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
