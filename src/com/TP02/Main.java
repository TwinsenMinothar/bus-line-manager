package com.TP02;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Onibus> onibusVet;

    public static void main(String[] args) {
        FileIO fi = new FileIO();
        fi.readFile();
        JFrame mainMenu = new JFrame("Fuck My Life");
        mainMenu.setContentPane(new GUI().getMainPanel());
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.pack();
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setVisible(true);
    }

    public static List<Onibus> getOnibusVet() {
        return onibusVet;
    }

    public static void setOnibusVet(ArrayList<Onibus> onibusIOVet) {
        onibusVet = new ArrayList<>(onibusIOVet);
    }

    public static int getOnibusPorNome(String nome) {
        for (int i = 0; i < onibusVet.size(); i++) {
            if (onibusVet.get(i).getNomeDaLinha().equals(nome))
                return i;
        }
        return -1;
    }
}
