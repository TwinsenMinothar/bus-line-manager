package com.TP02;

public class Aposentado extends Passageiro {

    private String rg;

    public Aposentado() {
    }

    public Aposentado(String nome, String rg) {
        this.rg = rg;
        this.setNome(nome);
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
