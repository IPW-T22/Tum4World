package com.github.ipwt22.tum4world.models;

import com.google.gson.Gson;

import java.io.Serializable;


public class Citazione implements Serializable {
    public Citazione() {
    }

    // ATRIBUTI
    private int id;
    private String citazione;
    private String autore;

    // GETTER e SETTER

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    // TOSTRING e TOJSON
    @Override
    public String toString() {
        return "Citazione{" +
                "citazione='" + citazione + '\'' +
                ", autore='" + autore + '\'' +
                '}';
    }

    public static final Gson GSON = new Gson();

    public String toJson() {
        return GSON.toJson(this);
    }
}
