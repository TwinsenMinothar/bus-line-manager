package com.TP02;

import java.util.ArrayList;
import java.util.List;

public class Onibus {
    private int id;
    private float precoPassagem;
    private float caixa;
    private String nomeDaLinha;
    private String motorista;
    private List<Passageiro> passageiroVet;
    private double taxa;

    public Onibus(String nomeDaLinha, String nomeDoMotorista, float precoPassagem,List<Passageiro> passageiroVet) {
        this.nomeDaLinha = nomeDaLinha;
        this.motorista = nomeDoMotorista;
        this.precoPassagem = precoPassagem;
        this.passageiroVet = new ArrayList<>(passageiroVet);
    }

    public void addPassageiro(Passageiro p) {
        if (p.getClass() == Passageiro.class)
            caixa += precoPassagem;
        if (p.getClass() == Estudante.class)
            caixa += precoPassagem / 2;
        passageiroVet.add(p);
    }

    public void imprimirPassageiro() {
        for (Passageiro pas : passageiroVet) {
            System.out.print(pas.getNome() + " ");
        }
    }

    public double calculaTotalArrecadado() {
        return caixa;
    }

    public String getNomeDaLinha() {
        return nomeDaLinha;
    }

    public float getPrecoPassagem() {
        return precoPassagem;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setPrecoPassagem(float precoPassagem) {
        this.precoPassagem = precoPassagem;
    }

    public void setNomeDaLinha(String nomeDaLinha) {
        this.nomeDaLinha = nomeDaLinha;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public List<Passageiro> getPassageiroVet() {
        return passageiroVet;
    }
}
