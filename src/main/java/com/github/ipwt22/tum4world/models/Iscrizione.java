package com.github.ipwt22.tum4world.models;

import java.io.Serializable;
import java.util.List;

public class Iscrizione implements Serializable {

    public Iscrizione(){}
    private int id;
    private String username;
    private int attivita_id;

    public int getAttivita_id() {
        return attivita_id;
    }

    public void setAttivita_id(int attivita_id) {
        this.attivita_id = attivita_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
