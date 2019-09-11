package com.example.avaliacaoluciane.Model;

import java.io.Serializable;

public class Config implements Serializable {

    private Integer minimo;
    private Integer maximo;

    public Config() {
    }

    public Config(Integer minimo, Integer maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public Integer getMinimo() {
        return minimo;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    public void setMinimo(String minimo) {
        try {
            this.minimo = Integer.parseInt(minimo);
        } catch (Exception e) {
            this.minimo = null;
        }
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    public void setMaximo (String maximo) {
        try {
            this.maximo = Integer.parseInt(maximo);
        } catch (Exception e) {
            this.maximo = null;
        }
    }

    @Override
    public String toString() {
        return "Config{" +
                "minimo=" + minimo +
                ", maximo=" + maximo +
                '}';
    }
}
