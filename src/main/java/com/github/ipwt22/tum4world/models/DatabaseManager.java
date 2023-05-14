package com.github.ipwt22.tum4world.models;

public class DatabaseManager {
    //settings per il database

    public boolean signUp(Utente user){

        return true;
    }

    public Utente getUserFromUsername(String username){
        Utente user = new Utente();

        return user;
    }

    public boolean setKeyOfUser(String username, String key){

        return true;
    }

    public Citazione getRandomCitazione(){
        Citazione citazione = new Citazione();
        citazione.setCitazione("LASCIATE OGNI SPERANZA A VOI CHE ENTRATE");
        return citazione;
    }
}
