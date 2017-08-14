package com.TP02;

public class Estudante extends Passageiro {

    private String ra;

    public Estudante() {
    }

    public Estudante(String nome, String ra) {
        this.setNome(nome);
        this.ra = ra;
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
