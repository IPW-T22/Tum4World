package com.github.ipwt22.tum4world.models;

import java.io.Serializable;
import java.util.HashMap;

public class Contatori implements Serializable {
    // TODO: implementare il contatore con il DB
    private HashMap<String, Integer> contatori = new HashMap<String, Integer>();

    public void incrementa(String path) {
        if (contatori.containsKey(path)) {
            contatori.put(path, contatori.get(path) + 1);
        } else {
            contatori.put(path, 1);
        }
    }

    public int getContatore(String path) {
        return contatori.getOrDefault(path, 0);
    }

    public HashMap<String, Integer> getContatori() {
        return contatori;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contatori{\n");
        for (String key : contatori.keySet()) {
            sb.append('\t').append(key).append(": ").append(contatori.get(key)).append(",\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
