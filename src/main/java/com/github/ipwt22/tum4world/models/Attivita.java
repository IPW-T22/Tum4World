package com.github.ipwt22.tum4world.models;

import java.io.Serializable;

public class Attivita implements Serializable {
    private int id;
    private String titolo = "null";
    private String descrizione = "null";
    private String immagine = "null";

    private boolean iscritto = false;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIscritto() {
        return iscritto;
    }

    public void setIscritto(boolean iscritto) {
        this.iscritto = iscritto;
    }
}
