package com.example.avaliacaoluciane.Model;

public class DadoBO {
    private Dado dado;

    public DadoBO(Dado dado) {
        this.dado = dado;
    }

    public boolean validaNome(){
        return this.dado.getNome()!=null && !this.dado.getNome().isEmpty();
    }

    public boolean validaIdade(){
        return this.dado.getIdade()!=null && this.dado.getIdade() >= 0;
    }
}
