package com.github.ipwt22.tum4world.models;

import java.io.Serializable;

public class Citazione implements Serializable {
    private String citazione;

    public Citazione() {
    }

    public String getCitazione() {
        return citazione;
    }

    public void setCitazione(String citazione) {
        this.citazione = citazione;
    }
}
