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
    private JCheckBox deletarCheckBox;
    private JLabel totalArrecadadoLabel;
    private JButton deletarOK;
    private int i = -1;
    private String nomeViagem;
    private boolean flag;

    public EditViagDialog() {
        flag = false;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        updateComboBox();
        deletarOK = new JButton("OK");
        totalArrecadadoLabel.setText("0");

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
                    totalArrecadadoLabel.setText(String.valueOf(onibusVet.get(i).getTotalArrecadado()));
                }
            }
        });

        passageirosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Objects.equals(nomeLinha.getText(), "")) {
                    JOptionPane.showMessageDialog(null, "Selecione alguma Viagem!!", null, JOptionPane.ERROR_MESSAGE);
                } else
                    ListaPassageiros.main(new String[]{nomeViagem});
            }
        });
        precoPass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                super.keyTyped(keyEvent);
                if (Character.isAlphabetic(keyEvent.getKeyChar())) {
                    JOptionPane.showMessageDialog(null, "Somente números no preço da passagem!", null, JOptionPane.ERROR_MESSAGE);
                    flag = true;
                } else
                    flag = false;
            }
        });

        deletarOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.err.println("here");
            }
        });

    }

    private void onOK() {
        if (Objects.equals(nomeLinha.getText(), "") || Objects.equals(nomeMot.getText(), "") || Objects.equals(precoPass.getText(), "") || i == -1 || flag)
            JOptionPane.showMessageDialog(null, "Dados Inválidos!!", null, JOptionPane.ERROR_MESSAGE);
        else {
            if (deletarCheckBox.isSelected()) {
                boolean yn = ConfirmDialog.main("Voce deseja deletar a viagem " + nomeLinha.getText() + " ?");
                if (yn) {
                    int indice = Main.getOnibusPorNome(nomeLinha.getText());
                    if (indice == -1)
                        JOptionPane.showMessageDialog(null, "Viagem com nome " + nomeLinha.getText() + " nao existe!", null, JOptionPane.ERROR_MESSAGE);
                    else {
                        onibusVet.remove(indice);
                        JOptionPane.showMessageDialog(null, "Viagem com nome " + nomeLinha.getText() + " removida!", null, JOptionPane.INFORMATION_MESSAGE);
                        //dispose();
                        //EditViagDialog.main(null);
                        updateComboBox();
                        return;
                    }
                } else {
                    //dispose();
                    //EditViagDialog.main(null);
                    updateComboBox();
                    return;
                }
            }
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
