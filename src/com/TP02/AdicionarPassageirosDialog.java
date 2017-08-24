package com.TP02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.TP02.Main.icone;

public class AdicionarPassageirosDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JTextField nomeField;
    private JTextField rGRATxField;
    private JLabel rGRALabel;
    private static List<Passageiro> passageiros;
    private LocalDateTime data =  LocalDateTime.now();

    public AdicionarPassageirosDialog() {
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();
        int ano = data.getYear();
        int diaAno = data.getDayOfYear();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        rGRALabel.setVisible(false);
        rGRATxField.setVisible(false);
        comboBox1.addItem("Comum");
        comboBox1.addItem("Estudante");
        comboBox1.addItem("Aposentado(a)");
        passageiros = new ArrayList<>();

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

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (comboBox1.getSelectedItem() != "Comum") {
                    rGRALabel.setVisible(true);
                    rGRATxField.setVisible(true);
                    dialog.pack();
                } else {
                    rGRALabel.setVisible(false);
                    rGRATxField.setVisible(false);
                    dialog.pack();
                }
            }
        });
    }

    private void onOK() {
        if(!Objects.equals(nomeField.getText(), "")) {
            if (comboBox1.getSelectedIndex() == 0)
                passageiros.add(new Passageiro(nomeField.getText(),data));
            if (comboBox1.getSelectedIndex() == 1)
                passageiros.add(new Estudante(nomeField.getText(), rGRATxField.getText(),data));
            if (comboBox1.getSelectedIndex() == 2)
                passageiros.add(new Aposentado(nomeField.getText(), rGRATxField.getText(),data));
        }else
            JOptionPane.showMessageDialog(null, "Dados Invlidos!!",null,JOptionPane.ERROR_MESSAGE);
        nomeField.setText("");
        rGRATxField.setText("");
    }

    private void onCancel() {

        dispose();
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    static AdicionarPassageirosDialog dialog;

    public static List<Passageiro> main(String[] args) {
        dialog = new AdicionarPassageirosDialog();
        dialog.setIconImage(icone);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        return passageiros;
    }
}
