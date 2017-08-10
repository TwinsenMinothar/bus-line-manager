package com.TP02;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;

import static com.TP02.Onibus.getOnibusPorNome;
import static com.TP02.Onibus.getOnibusVet;
import static com.TP02.Onibus.onibusVet;

public class GUI {
    private JPanel mainPanel;
    private JButton novaViagemButton;
    private JButton sairButton;
    private JButton configurarViagensButton;
    private JPanel configViagemPanel;
    private JComboBox listaDeViagens;
    private JLabel configurandoViagensLabel;
    private JPanel novaViagemPanel;
    private JTextField nomeDaLinha;
    private JTextField nomeDoMotorista;
    private JTextField precoDaPassagem;
    private JButton confirmarNovaViagemButton;
    private JLabel criandoViagLabel;
    private JPanel ConfigViagEditPanel;
    private JTextField nomeLinha;
    private JTextField nomeMot;
    private JTextField precoPass;
    private JButton confirmarConfigButton;
    private JPanel criandoNovaViagemLabelPanel;
    private int i = -1;

    public GUI() {
        configViagensMenusState(false);
        novaViagemMenusState(false);

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });

        novaViagemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                configViagensMenusState(false);
                novaViagemMenusState(true);
                nomeDaLinha.removeAll();
                nomeDoMotorista.removeAll();
                precoDaPassagem.removeAll();
            }
        });
        configurarViagensButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                configViagensMenusState(true);
                novaViagemMenusState(false);
            }
        });
        updateComboBox();
        confirmarNovaViagemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onibusVet.add(new Onibus(nomeDaLinha.getText(), nomeDoMotorista.getText(), Float.parseFloat(precoDaPassagem.getText())));
                JOptionPane.showMessageDialog(null, "Nova viagem criada com sucesso!!");
                novaViagemMenusState(false);
                updateComboBox();
            }
        });
        confirmarConfigButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (i == -1) return;
                onibusVet.get(i).setNomeDaLinha(nomeLinha.getText());
                onibusVet.get(i).setMotorista(nomeMot.getText());
                onibusVet.get(i).setPrecoPassagem(Float.parseFloat(precoPass.getText()));
                JOptionPane.showMessageDialog(null, "Viagem Editada com Sucesso!!");
                configViagensMenusState(false);
                updateComboBox();
            }
        });
        listaDeViagens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (listaDeViagens.getItemCount() != 0) {
                    String nomeViagem = listaDeViagens.getSelectedItem().toString();
                    i = getOnibusPorNome(nomeViagem);
                    if (i == -1) return;
                    nomeLinha.setText(onibusVet.get(i).getNomeDaLinha());
                    nomeMot.setText(onibusVet.get(i).getMotorista());
                    precoPass.setText(String.valueOf(onibusVet.get(i).getPrecoPassagem()));
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


    public void updateComboBox() {
        listaDeViagens.removeAllItems();
        for (Onibus item : getOnibusVet()) {
            listaDeViagens.addItem(item.getNomeDaLinha());
        }
    }

    private void configViagensMenusState(Boolean state) {
        configurandoViagensLabel.setVisible(state);
        configViagemPanel.setVisible(state);
    }

    private void novaViagemMenusState(Boolean state) {
        criandoViagLabel.setVisible(state);
        novaViagemPanel.setVisible(state);
    }

}
