package com.github.ipwt22.tum4world.models;

import java.io.Serializable;

public class Attivita implements Serializable {
    private String nome;
    private String urlImmagine;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImmagine() {
        return urlImmagine;
    }

    public void setUrlImmagine(String urlImmagine) {
        this.urlImmagine = urlImmagine;
    }
}
