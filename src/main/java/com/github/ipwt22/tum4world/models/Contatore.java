package com.github.ipwt22.tum4world.models;

import com.google.gson.Gson;

import java.io.Serializable;

public class Contatore implements Serializable {
    public Contatore() {
    }

    // ATTRIBUTI
    private int id;
    private String percorso;

    private int visite;

    // GETTER e SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPercorso() {
        return percorso;
    }

    public void setPercorso(String percorso) {
        this.percorso = percorso;
    }

    public int getVisite() {
        return visite;
    }

    public void setVisite(int visite) {
        this.visite = visite;
    }

    // TOSTRING e TOJSON
    @Override
    public String toString() {
        return "Contatore{" +
                "id=" + id +
                ", percorso='" + percorso + '\'' +
                ", visite=" + visite +
                '}';
    }

    public static final Gson GSON = new Gson();

    public String toJson() {
        return GSON.toJson(this);
    }
}
