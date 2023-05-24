package com.github.ipwt22.tum4world.models;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Date;

public class Donazione implements Serializable {
    public Donazione() {
    }

    // ATRIBUTI
    private int id;
    private Date data;
    private Utente utente;
    private double importo;

    // GETTER e SETTER
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // TOSTRING e TOJSON
    @Override
    public String toString() {
        return "Donazione{" +
                "id=" + id +
                ", data=" + data +
                ", utente=" + utente +
                ", importo=" + importo +
                '}';
    }

    public static final Gson GSON = new Gson();
    public String toJson() {
        return GSON.toJson(this);
    }

}
