package com.github.ipwt22.tum4world.models;

public class DB {
    //settings per il database

    public static boolean signUp(Utente user){

        return true;
    }

    public static Utente getUserFromUsername(String username){
        Utente user = new Utente();

        return user;
    }

    public static Utente getUserFromKey(String key){
        Utente user = new Utente();

        return user;
    }

    public static boolean setKeyOfUser(String username, String key){

        return true;
    }


    public static Citazione getRandomCitazione(){
        Citazione citazione = new Citazione();
        citazione.setCitazione("LASCIATE OGNI SPERANZA A VOI CHE ENTRATE");
        return citazione;
    }
}
