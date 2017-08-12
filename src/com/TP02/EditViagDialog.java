package com.TP02;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

import static com.TP02.Main.getOnibusPorNome;
import static com.TP02.Main.getOnibusVet;
import static com.TP02.Main.onibusVet;

public class EditViagDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel configViagemPanel;
    private JComboBox listaDeViagens;
    private JPanel ConfigViagEditPanel;
    private JTextField nomeLinha;
    private JTextField nomeMot;
    private JTextField precoPass;
    private JLabel configurandoViagensLabel;
    private JButton passageirosButton;
    private int i = -1;
    private String nomeViagem;

    public EditViagDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        updateComboBox();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { onOK(); }
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

        listaDeViagens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (listaDeViagens.getItemCount() != 0) {
                    nomeViagem = listaDeViagens.getSelectedItem().toString();
                    i = getOnibusPorNome(nomeViagem);
                    if (i == -1) return;
                    nomeLinha.setText(onibusVet.get(i).getNomeDaLinha());
                    nomeMot.setText(onibusVet.get(i).getMotorista());
                    precoPass.setText(String.valueOf(onibusVet.get(i).getPrecoPassagem()));
                }
            }
        });

        passageirosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            ListaPassageiros.main(new String[]{nomeViagem});
            }
        });
    }

    private void onOK() {
        if(Objects.equals(nomeLinha.getText(), "") || Objects.equals(nomeMot.getText(), "") || Objects.equals(precoPass.getText(), "") || i==-1)
            JOptionPane.showMessageDialog(null, "Dados Invlidos!!",null,JOptionPane.ERROR_MESSAGE);
        else {
            onibusVet.get(i).setNomeDaLinha(nomeLinha.getText());
            onibusVet.get(i).setMotorista(nomeMot.getText());
            onibusVet.get(i).setPrecoPassagem(Float.parseFloat(precoPass.getText()));
            JOptionPane.showMessageDialog(null, "Viagem Editada com Sucesso!!");
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void updateComboBox() {
        listaDeViagens.removeAllItems();
        for (Onibus item : getOnibusVet()) {
            listaDeViagens.addItem(item.getNomeDaLinha());
        }
    }

    public static void main(String[] args) {
        EditViagDialog dialog = new EditViagDialog();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        //System.exit(0);
    }
}
