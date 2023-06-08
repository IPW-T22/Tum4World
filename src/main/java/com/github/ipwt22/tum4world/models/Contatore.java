package com.github.ipwt22.tum4world.models;

import com.google.gson.Gson;

import java.io.Serializable;

public class Contatore implements Serializable {
    public Contatore() {
    }

    // ATTRIBUTI
    private String percorso;
    private String nome;
    private int visite;

    // GETTER e SETTER

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
                ", percorso='" + percorso + '\'' +
                ", visite=" + visite +
                '}';
    }

    public static final Gson GSON = new Gson();

    public String toJson() {
        return GSON.toJson(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
