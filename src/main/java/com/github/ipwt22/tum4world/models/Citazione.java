package com.github.ipwt22.tum4world.models;

import java.io.Serializable;

public class Citazione implements Serializable {
    private String citazione;
    private String autore;

    public Citazione() {
    }

    public String getCitazione() {
        return citazione;
    }

    public void setCitazione(String citazione) {
        this.citazione = citazione;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
}
