package com.TP02;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Passageiro implements Serializable {

    private String nome;
    LocalDateTime data;

    public Passageiro() {
    }

    public Passageiro(String nome, LocalDateTime data) {
        this.nome = nome;
        this.data = data;
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

    public LocalDateTime getData() {
        return this.data;
    }
}
