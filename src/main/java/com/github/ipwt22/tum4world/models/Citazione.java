package com.github.ipwt22.tum4world.models;

import com.google.gson.Gson;

import java.io.Serializable;


public class Citazione implements Serializable {
    public Citazione() {
    }

    // ATRIBUTI
    private int id;
    private String testo;
    private String autore;

    // GETTER e SETTER

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
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
                "testo='" + testo + '\'' +
                ", autore='" + autore + '\'' +
                '}';
    }

    public static final Gson GSON = new Gson();

    public String toJson() {
        return GSON.toJson(this);
    }
}
