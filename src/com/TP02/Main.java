package com.TP02;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Onibus.onibusVet = new ArrayList<>();
        JFrame frame = new JFrame("Fuck My Life");
        frame.setContentPane(new GUI().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024,768);
        frame.setVisible(true);
    }
}
