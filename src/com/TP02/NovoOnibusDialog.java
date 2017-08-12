package com.TP02;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.Objects;

import static com.TP02.Main.onibusVet;

public class NovoOnibusDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel novaViagemPanel;
    private JTextField nomeDaLinha;
    private JTextField nomeDoMotorista;
    private JTextField precoDaPassagem;
    private JLabel configurandoViagensLabel;
    private JButton adicionarPassageirosButton;
    private List<Passageiro> passVet;

    public NovoOnibusDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        adicionarPassageirosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               passVet =  AdicionarPassageirosDialog.main(null);

            }
        });
    }

    private void onOK() {
        if (!Objects.equals(nomeDaLinha.getText(), "") && !Objects.equals(nomeDoMotorista.getText(), "") && !Objects.equals(precoDaPassagem.getText(), "")) {
            onibusVet.add(new Onibus(nomeDaLinha.getText(), nomeDoMotorista.getText(), Float.parseFloat(precoDaPassagem.getText()),passVet));
            JOptionPane.showMessageDialog(null, "Nova viagem criada com sucesso!!");
        }
        else
            JOptionPane.showMessageDialog(null, "Dados Invlidos!!",null,JOptionPane.ERROR_MESSAGE);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        NovoOnibusDialog dialog = new NovoOnibusDialog();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        //System.exit(0);
    }
}
