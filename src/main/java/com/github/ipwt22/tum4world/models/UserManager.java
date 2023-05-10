package com.github.ipwt22.tum4world.models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;

public class UserManager {
    public Utente user = new Utente();
    //QUI DEVO AVERE UNA CLASSE CHE MI PERMETTE DI INTERROGARE IL DB
    public UserManager() {}

    public UserManager(String username) {
        //POPOLO user dal database fetchando tramite l'username
    }

    public boolean signIn(HttpServletRequest request, String username, String hashPassword){
        HttpSession session = null;
        if (username.equals(user.getUsername()) && hashPassword.equals(user.getHashPassword())) {
            if(request.getParameter("cookieAccepted")!=null && request.getParameter("cookieAccepted").equals("true")) {
                session = request.getSession();
                session.setAttribute("BeanUtente", user);
            }
            else{
                Random random = new Random();
                user.setKey(user.getUsername() + ":" + random.nextInt());
            }
            return true;
        }
        return false;
    }

    public boolean signUp(HttpServletRequest request, String nome, String cognome, Date dataDiNascita, String email, String telefono, Utente.Ruolo ruolo, String username, String hashPassword){
        HttpSession session = null;
        if(user.getUsername()!=null)
            return false;
        user.setNome(nome);
        user.setCognome(cognome);
        user.setDataDiNascita(dataDiNascita);
        user.setEmail(email);
        user.setTelefono(telefono);
        user.setRuolo(ruolo);
        user.setUsername(username);
        user.setHashPassword(hashPassword);
        //REGISTRA UTENTE INVOCANDO IL DB su user
        if(request.getParameter("cookieAccepted")!=null) {
            session = request.getSession();
            session.setAttribute("BeanUtente", user);
        }
        else{
            Random random = new Random();
            user.setKey(user.getUsername() + ":" + random.nextInt());
        }
        return true;
    }
    public void logout(HttpServletRequest request){
        HttpSession session = request.getSession (false);
        if (session!=null)
            session.invalidate();
        user.setKey("null");
    }

    public void populateUser(String username){
        //INVOCO IL DB PER OTTENERE I DATI DI USERNAME
    }
}
