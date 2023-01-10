package view;

import controller.AllObjekModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class userGUI {
    JFrame LogReg = new JFrame();
    JLabel us, top;
    JTextField texttu;
    JRadioButton pulsa1,pulsa2,pulsa3,pulsa4;
    JLabel labeltu, labelpulsa,labelriwayat,labelsaldo;
    JButton tu, exit, beli;

    JTable tabel = new JTable();
    JTable tabel2 = new JTable();
    JScrollPane scrolladmin = new JScrollPane(tabel);
    JScrollPane scrolladmin2 = new JScrollPane(tabel2);
    private boolean belii = false;

    public userGUI() {
        scrolladmin = new JScrollPane(tabel);
        LogReg.setSize(750, 1000);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.YELLOW);

        top = new JLabel("Dashboard User");
        top.setBounds(250, 30, 500, 50);
        top.setFont(new Font("Times New Roman", 1, 40));
        LogReg.add(this.top);

        labelriwayat = new JLabel("Riwayat");
        labelriwayat.setBounds(400,70,300,100);
        labelriwayat.setFont(new Font("Times New Roman", 1, 20));
        LogReg.add(labelriwayat);
        scrolladmin.setBounds(400, 140, 300, 200);
        tabel.setModel(AllObjectController.user.History());

        labeltu = new JLabel("Masukkan Nominal : ");
        labeltu.setBounds(30, 100, 200, 30);
        labeltu.setFont(new Font("Times New Roman", 1, 20));
        LogReg.add(labeltu);
        labeltu = new JLabel("Rp. : ");
        labeltu.setBounds(30, 140, 200, 30);
        labeltu.setFont(new Font("Times New Roman", 1, 20));
        LogReg.add(labeltu);
        texttu = new JTextField();
        texttu.setBounds(65, 140, 200, 30);
        LogReg.add(texttu);
        tu = new JButton("Top Up");
        tu.setBounds(30, 180, 100, 30);
        tu.setBackground(Color.RED);
        LogReg.add(tu);

        labelpulsa = new JLabel("Pilih Nominal Pulsa : ");
        labelpulsa.setBounds(30, 300, 200, 30);
        labelpulsa.setFont(new Font("Times New Roman", 1, 20));
        LogReg.add(labelpulsa);
        pulsa1 = new JRadioButton("Rp.10.000");
        pulsa1.setBounds(30, 350, 100, 30);
        pulsa1.setBackground(Color.CYAN);
        LogReg.add(pulsa1);
        pulsa2 = new JRadioButton("Rp.20.000");
        pulsa2.setBounds(30, 380, 100, 30);
        pulsa2.setBackground(Color.CYAN);
        LogReg.add(pulsa2);
        pulsa3 = new JRadioButton("Rp.50.000");
        pulsa3.setBounds(30, 410, 100, 30);
        pulsa3.setBackground(Color.CYAN);
        LogReg.add(pulsa3);
        pulsa4 = new JRadioButton("Rp.100.000");
        pulsa4.setBounds(30, 440, 100, 30);
        pulsa4.setBackground(Color.CYAN);
        LogReg.add(pulsa4);
        beli = new JButton("Beli");
        beli.setBounds(50, 500, 100, 30);
        beli.setBackground(Color.RED);
        LogReg.add(beli);

        labelsaldo = new JLabel("Cek Saldo : ");
        labelsaldo.setBounds(400, 380, 200, 30);
        labelsaldo.setFont(new Font("Times New Roman", 1, 20));
        LogReg.add(labelsaldo);
        scrolladmin2.setBounds(400, 420, 300, 50);
        tabel2.setModel(AllObjectController.user.saldo());

        exit = new JButton("Keluar");
        exit.setBounds(600, 600, 100, 30);
        exit.setBackground(Color.RED);
        LogReg.add(exit);

        LogReg.add(scrolladmin);
        LogReg.add(scrolladmin2);
        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);
        tu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int nominal = Integer.parseInt(texttu.getText());
                    AllObjectController.user.topup(nominal);
                    JOptionPane.showMessageDialog((Component)null, " Top Up Rp."+nominal+" Berhasil", "information", 1);
                    new userGUI();
                    LogReg.dispose();
                } catch (Exception var4) {
                    JOptionPane.showMessageDialog((Component)null, "Minimal Top Up Rp.10.000", "information", 1);
                    kosong();
                }

            }
        });
        pulsa1.addActionListener(ae -> {
            if (pulsa1.isSelected()) {
                pulsa2.setSelected(false);
                pulsa3.setSelected(false);
                pulsa3.setSelected(false);
                AllObjectController.user.pmbl(10000);
                belii = true;
            }
        });
        pulsa2.addActionListener(ae -> {
            if (pulsa2.isSelected()) {
                pulsa1.setSelected(false);
                pulsa3.setSelected(false);
                pulsa4.setSelected(false);
                AllObjectController.user.pmbl(20000);
                belii = true;
            }
        });
        pulsa3.addActionListener(ae -> {
            if (pulsa3.isSelected()) {
                pulsa1.setSelected(false);
                pulsa2.setSelected(false);
                pulsa4.setSelected(false);
                AllObjectController.user.pmbl(50000);
                belii = true;
            }
        });
        pulsa4.addActionListener(ae -> {
            if (pulsa4.isSelected()) {
                pulsa1.setSelected(false);
                pulsa2.setSelected(false);
                pulsa3.setSelected(false);
                AllObjectController.user.pmbl(100000);
                belii = true;
            }
        });
        beli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (belii = true){
                    try {
                        JOptionPane.showMessageDialog(null, "Pulsa Berhasil Ditambakan", "information", JOptionPane.INFORMATION_MESSAGE);
                        new userGUI();
                        LogReg.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Username atau password salah", " information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                }
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new GUImain();
                LogReg.dispose();
            }
        });
    }
    void kosong() {
        texttu.setText((String)null);
    }
}
