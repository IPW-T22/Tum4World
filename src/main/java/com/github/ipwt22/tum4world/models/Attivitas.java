package com.github.ipwt22.tum4world.models;

import java.io.Serializable;
import java.util.List;

public class Attivitas implements Serializable {
    List<Attivita> list = null;
    public Attivitas(){}
    public Attivitas(List<Attivita> list) {
        this.list = list;
    }
    public List<Attivita> getList() {
        return list;
    }
    public void setList(List<Attivita> list) {
        this.list = list;
    }
}
