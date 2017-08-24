package com.TP02;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Onibus implements Serializable {
    private int id;
    private float precoPassagem;
    private float caixa;
    private String nomeDaLinha;
    private String motorista;
    private List<Passageiro> passageiroVet;
    private int totalEstudantes;
    private int totalAposentados;
    private int totalComuns;

    public Onibus(String nomeDaLinha, String nomeDoMotorista, float precoPassagem, List<Passageiro> passageiroVet) {
        this.nomeDaLinha = nomeDaLinha;
        this.motorista = nomeDoMotorista;
        this.precoPassagem = precoPassagem;
        this.caixa = 0;
        this.passageiroVet = new ArrayList<>(passageiroVet);
    }

    public void addPassageiro(Passageiro p) {
        if (p.getClass() == Passageiro.class)
            caixa += precoPassagem;
        if (p.getClass() == Estudante.class)
            caixa += precoPassagem / 2;
        passageiroVet.add(p);
    }

    public void imprimirPassageiros() {
        for (Passageiro pas : passageiroVet) {
            pas.imprimir();
        }
    }

    public float getTotalArrecadado(int mes) {
        this.caixa = 0;
        for (Passageiro pas : passageiroVet) {
            if (pas.data.getMonthValue() == mes) {
                if (pas.getClass() == Passageiro.class)
                    caixa += precoPassagem;
                else if (pas.getClass() == Estudante.class)
                    caixa += precoPassagem / 2;
            }
        }
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

    public int getTotalEstudantes(int mes) {
        totalEstudantes = 0;
        for (Passageiro pas : passageiroVet) {
            if (pas.data.getMonthValue() == mes) {
                if (Objects.equals(pas.getClass().getSimpleName(), Estudante.class.getSimpleName()))
                    totalEstudantes++;
            }
        }
        return totalEstudantes;
    }

    public int getTotalAposentados(int mes) {
        totalAposentados = 0;
        for (Passageiro pas : passageiroVet) {
            if (pas.data.getMonthValue() == mes) {
                if (Objects.equals(pas.getClass().getSimpleName(), Aposentado.class.getSimpleName()))
                    totalAposentados++;
            }
        }
        return totalAposentados;
    }

    public int getTotalComuns(int mes) {
        totalComuns = 0;
        for (Passageiro pas : passageiroVet)
            if (pas.data.getMonthValue() == mes) {
                if (Objects.equals(pas.getClass().getSimpleName(), Passageiro.class.getSimpleName()))
                    totalComuns++;
            }
        return totalComuns;
    }
}
