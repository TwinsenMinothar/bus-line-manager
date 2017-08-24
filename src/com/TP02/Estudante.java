package com.TP02;

import java.time.LocalDateTime;

public class Estudante extends Passageiro {

    private String ra;

    public Estudante() {
    }

    public Estudante(String nome, String ra, LocalDateTime data) {
        this.setNome(nome);
        this.ra = ra;
        this.data  = data;
    }

    @Override
    public double calcPaga(double taxa) {
        return taxa / 2;
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("RA: " + this.ra);
    }

    public String getRa() {
        return ra;
    }
}
