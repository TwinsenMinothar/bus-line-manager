package com.TP02;

public class Estudante extends Passageiro {

    private String ra;

    public Estudante(){}

    public Estudante(String nome, String ra){
        this.setNome(nome);
        this.ra = ra;
    }

    @Override
    public double calcPaga(double taxa){return 0;}

    @Override
    public void imprimir(){}

    public String getRa() {
        return ra;
    }
}
