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

import static com.TP02.Main.icone;

public class ListaPassageiros extends JDialog {
    private static String nomeDaV;
    private static String mesDesejado;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable tabelaPassageiros;
    private JButton adicionarPassageirosButton;
    private List<Passageiro> vetPas;
    private List<Passageiro> vetPasAdd;
    private Onibus onibus;
    private Object[] colunas = new String[]{"Data do Ingresso", "Tipo", "Nome", "RG/RA", "Valor Pago"};

    public ListaPassageiros() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        onibus = Main.onibusVet.get(Main.getOnibusPorNome(nomeDaV));
        vetPas = onibus.getPassageiroVet();

        DefaultTableModel model;
        model = new DefaultTableModel();
        model.setColumnCount(5);
        model.setRowCount(vetPas.size());
        model.setColumnIdentifiers(colunas);
        tabelaPassageiros.setDefaultEditor(Object.class, null);

        for (int i = 0; i < vetPas.size(); i++) {
            int j = 0;
            if(Integer.parseInt(mesDesejado)+1 == vetPas.get(i).data.getMonthValue()) {
                String data = String.valueOf(vetPas.get(i).data.getDayOfMonth()) + "/" + String.valueOf(vetPas.get(i).data.getMonthValue()) + "/" + String.valueOf(vetPas.get(i).data.getYear());
                model.setValueAt(data, i, j++);
                model.setValueAt(vetPas.get(i).getClass().getSimpleName(), i, j++);
                model.setValueAt(vetPas.get(i).getNome(), i, j++);
                if (Objects.equals(vetPas.get(i).getClass().getSimpleName(), "Estudante")) {
                    model.setValueAt(((Estudante) vetPas.get(i)).getRa(), i, j++);
                    model.setValueAt(onibus.getPrecoPassagem() / 2, i, j);
                } else if (Objects.equals(vetPas.get(i).getClass().getSimpleName(), "Aposentado")) {
                    model.setValueAt(((Aposentado) vetPas.get(i)).getRg(), i, j++);
                    model.setValueAt(0, i, j);
                } else {
                    model.setValueAt("", i, j++);
                    model.setValueAt(onibus.getPrecoPassagem(), i, j);
                }
            }
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

        adicionarPassageirosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vetPasAdd = AdicionarPassageirosDialog.main(null);
                vetPas.addAll(vetPasAdd);
                dispose();
                ListaPassageiros.main(new String[]{nomeDaV});
            }
        });
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
        mesDesejado = args[1];
        ListaPassageiros dialog = new ListaPassageiros();
        dialog.setIconImage(icone);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
