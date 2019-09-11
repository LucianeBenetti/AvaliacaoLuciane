package com.example.avaliacaoluciane.Model;

import java.io.Serializable;

public class Dado implements Serializable {
    private String nome;
    private Integer idade;

    public Dado(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Dado() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setIdade(String idade) {
        try {
            this.idade = Integer.parseInt(idade);
        } catch (Exception e) {
            this.idade = null;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
               "Idade: " + idade + "\n";
    }
}
