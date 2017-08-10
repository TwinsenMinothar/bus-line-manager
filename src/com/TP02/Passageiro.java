package com.TP02;

public class Passageiro {

    private String nome;

    public Passageiro(){}

    public Passageiro(String nome){
        this.nome = nome;
    }

    public double calcPaga(double taxa){return 0;}

    public void imprimir(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
