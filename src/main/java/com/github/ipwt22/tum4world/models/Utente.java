package com.github.ipwt22.tum4world.models;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class Utente implements Serializable {

    public enum Ruolo {
        SIMPATIZZANTE(1),
        ADERENTE(2),
        AMMINISTRATORE(3);

        private int value;
        private Ruolo(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
    private String nome = "null";
    private String cognome = "null";
    private Date dataDiNascita = null;
    private String email = "null";
    private String telefono = "null";
    private Ruolo ruolo = Ruolo.SIMPATIZZANTE;

    private String username = "null";
    private String hashPassword = "null";

    private String token = "null";

    public Utente() {
    }

    public Utente(String nome, String cognome, Date dataDiNascita, String email, String telefono, Ruolo ruolo, String username, String hashPassword) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.telefono = telefono;
        this.ruolo = ruolo;
        this.username = username;
        this.hashPassword = hashPassword;
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

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String get_value_from_cookie(String name, HttpServletRequest request){
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

    public void setUser(Utente user){
        this.nome = user.getNome();
        this.cognome = user.getCognome();
        this.token = user.getToken();
        this.email = user.getToken();
        this.telefono = user.getTelefono();
        this.ruolo = user.getRuolo();
        this.username = user.getUsername();
        this.dataDiNascita = user.getDataDiNascita();
        this.hashPassword = user.getHashPassword();
    }

    public void populateUser(String username){
        Utente user = DB.getUserFromUsername(username);
        if(user!=null)
            setUser(user);
    }

    //fa efettuare il login
    public boolean login(HttpServletRequest request, String username, String hashPassword){
        HttpSession session = null;
        Utente user = DB.getUserFromUsername(username);
        String cookieAcceptedVal = get_value_from_cookie("cookieAccepted", request);
        //se il login è corretto
        if (username.equals(user.getUsername()) && hashPassword.equals(user.getHashPassword())) {
            if(cookieAcceptedVal!=null && cookieAcceptedVal.equals("true")) {
                session = request.getSession();
                session.setAttribute("BeanUtente", user);
            }
            else{
                Random random = new Random();
                token = username + ":" + random.nextInt( 100000);
                System.out.println(token);
                DB.setKeyOfUser(username, token);
            }
            return true;
        }
        return false;
    }

    public boolean signUp(HttpServletRequest request, String nome, String cognome, Date dataDiNascita, String email, String telefono, Utente.Ruolo ruolo, String username, String hashPassword){
        HttpSession session = null;
        Utente user = DB.getUserFromUsername("username");
        if(false)
            return false;
        setUser(user);
        DB.signUp(user);
        if(request.getParameter("cookieAccepted")!=null) {
            session = request.getSession();
            session.setAttribute("utente", user);
        }
        else{
            Random random = new Random();
            token = username + ":" + random.nextInt(100000);
            DB.setKeyOfUser(username, token);
        }
        return true;
    }
    public void logout(HttpServletRequest request){ //l'utente corrente effettua il logout
        HttpSession session = request.getSession (false);
        if (session!=null)
            session.invalidate();
        token = "null";
        DB.setKeyOfUser(username, token);
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
