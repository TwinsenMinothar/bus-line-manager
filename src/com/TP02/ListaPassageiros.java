package com.TP02;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Objects;

public class ListaPassageiros extends JDialog {
    private static String nomeDaV;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable tabelaPassageiros;
    private List<Passageiro> vetPas;
    private Object[] colunas = new String[]{"Tipo", "Nome", "RG/RA"};

    public ListaPassageiros() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        vetPas = Main.onibusVet.get(Main.getOnibusPorNome(nomeDaV)).getPassageiroVet();

        DefaultTableModel model;
        model = new DefaultTableModel();
        model.setColumnCount(3);
        model.setRowCount(vetPas.size());
        model.setColumnIdentifiers(colunas);
        tabelaPassageiros.setDefaultEditor(Object.class,null);

        for (int i = 0; i < vetPas.size(); i++) {
            int j = 0;
            model.setValueAt(vetPas.get(i).getClass().getSimpleName(), i, j++);
            model.setValueAt(vetPas.get(i).getNome(), i, j++);
            if (Objects.equals(vetPas.get(i).getClass().getSimpleName(), "Estudante")) {
                model.setValueAt(((Estudante) vetPas.get(i)).getRa(), i, j);
            } else if (Objects.equals(vetPas.get(i).getClass().getSimpleName(), "Aposentado")) {
                model.setValueAt(((Aposentado) vetPas.get(i)).getRg(), i, j);
            } else
                model.setValueAt("", i, j);
        }
        tabelaPassageiros.setModel(model);

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
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void atualizaTabela() {

    }

    public static void main(String[] args) {
        nomeDaV = args[0];
        ListaPassageiros dialog = new ListaPassageiros();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
