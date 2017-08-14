package com.TP02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel mainPanel;
    private JButton novaViagemButton;
    private JButton sairButton;
    private JButton configurarViagensButton;

    public GUI() {

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FileIO fi = new FileIO();
                fi.writeFile();
                System.exit(0);
            }
        });

        novaViagemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NovoOnibusDialog.main(null);
            }
        });

        configurarViagensButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EditViagDialog.main(null);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}