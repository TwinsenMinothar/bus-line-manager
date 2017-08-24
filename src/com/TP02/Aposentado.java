package com.TP02;

import java.time.LocalDateTime;

public class Aposentado extends Passageiro {

    private String rg;

    public Aposentado() {
    }

    public Aposentado(String nome, String rg, LocalDateTime data) {
        this.rg = rg;
        this.setNome(nome);
        this.data = data;
    }

    @Override
    public double calcPaga(double taxa) {
        return 0;
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("RG: " + this.rg);
    }

    public String getRg() {
        return rg;
    }
}
