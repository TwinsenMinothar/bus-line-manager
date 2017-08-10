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
    static List<Onibus> onibusVet;
    private double taxa;

    public static List<Onibus> getOnibusVet() {
        return onibusVet;
    }

    public Onibus(String nomeDaLinha, String nomeDoMotorista, float precoPassagem) {
        this.nomeDaLinha = nomeDaLinha;
        this.motorista = nomeDoMotorista;
        this.precoPassagem = precoPassagem;
        passageiroVet = new ArrayList<>();
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

    public static void novoOnibus(String nomeDaLinha) {
        //System.out.println(nomeDaLinha);
        onibusVet.add(new Onibus(nomeDaLinha, "Carlos", 0));

    }

    public String getNomeDaLinha() {
        return nomeDaLinha;
    }

    public static int getOnibusPorNome(String nome) {
        for (int i = 0; i < onibusVet.size(); i++) {
            if (onibusVet.get(i).getNomeDaLinha().equals(nome))
                return i;
        }
        return -1;
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

}
