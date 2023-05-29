package com.github.ipwt22.tum4world.models;

import java.io.Serializable;
import java.util.List;

public class Utenti implements Serializable {
    List<Utente> list = null;
    public Utenti(){}
    public Utenti(List<Utente> list) {
        this.list = list;
    }
    public List<Utente> getList() {
        return list;
    }
    public void setList(List<Utente> list) {
        this.list = list;
    }
}
