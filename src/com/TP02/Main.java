package com.TP02;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Onibus> onibusVet;
    public static Image icone;
    static {
        try {
            icone = ImageIO.read(Main.class.getResource("Assets/Onibus.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileIO fi = new FileIO();
        fi.readFile();
        JFrame mainMenu = new JFrame();
        mainMenu.setContentPane(new GUI().getMainPanel());
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setIconImage(icone);
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
