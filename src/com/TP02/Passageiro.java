package com.TP02;

import java.io.Serializable;

public class Passageiro implements Serializable {

    private String nome;

    public Passageiro() {
    }

    public Passageiro(String nome) {
        this.nome = nome;
    }

    public double calcPaga(double taxa) {
        return taxa;
    }

    public void imprimir() {
        System.out.println("Nome: " + this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
