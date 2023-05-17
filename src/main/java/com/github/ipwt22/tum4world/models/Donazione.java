package com.github.ipwt22.tum4world.models;

import java.io.Serializable;
import java.util.Date;

public class Donazione implements Serializable {
    private Date data;
    private Utente utente;
    private int amount;

    public Donazione() {
    }

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
