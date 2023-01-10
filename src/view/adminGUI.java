package view;

import controller.UserController;
import controller.admincontroller;
import entity.AdminEntity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class adminGUI {
    JFrame LogReg = new JFrame();
    JLabel us, top;
    JTextField textnomor,textcari, textnotelp,textnama,textalamat, textbaru,textusername;
    JLabel labelnomor,labeledit,labeldaftar,labelhapus,labelusername;
    JButton hapus,editnotelp,editnama,editalamat,editusername, exit;
    JTable tabeluser = new JTable();
    JScrollPane scrolladmin = new JScrollPane(tabeluser);

    public adminGUI() {
        scrolladmin = new JScrollPane(tabeluser);
        LogReg.setSize(900, 600);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.YELLOW);

        top = new JLabel("Dashboard Admin");
        top.setBounds(260, 30, 500, 50);
        top.setFont(new Font("Times New Roman", 1, 40));
        LogReg.add(top);
        scrolladmin.setBounds(50, 180, 500, 200);
        tabeluser.setModel(AllObjectController.admin.viewUser());
        LogReg.add(scrolladmin);

        labeldaftar = new JLabel("Daftar User");
        labeldaftar.setFont(new Font("Times New Roman", 1, 20));
        labeldaftar.setBounds(50, 110, 210, 100);
        LogReg.add(labeldaftar);

        labelusername = new JLabel("Masukkan Username : ");
        labelusername.setBounds(570, 170, 200, 30);
        LogReg.add(labelusername);
        textcari = new JTextField();
        textcari.setBounds(570, 200, 200, 30);
        LogReg.add(textcari);

        labeledit = new JLabel("Edit User");
        labeledit.setFont(new Font("Times New Roman", 1, 20));
        labeledit.setBounds(570, 110, 210, 100);
        LogReg.add(labeledit);

        labelusername = new JLabel("Masukkan Username Baru: ");
        labelusername.setBounds(570, 240, 200, 30);
        LogReg.add(labelusername);
        textbaru = new JTextField();
        textbaru.setBounds(570, 280, 200, 30);
        LogReg.add(textbaru);
        editusername = new JButton("Edit");
        editusername.setBounds(770, 280, 100, 30);
        editusername.setBackground(Color.RED);
        LogReg.add(editusername);

        labelnomor = new JLabel("Masukkan No Telp Baru: ");
        labelnomor.setBounds(570, 320, 200, 30);
        LogReg.add(labelnomor);
        textnotelp = new JTextField();
        textnotelp.setBounds(570, 360, 200, 30);
        LogReg.add(textnotelp);
        editnotelp = new JButton("Edit");
        editnotelp.setBounds(770, 360, 100, 30);
        editnotelp.setBackground(Color.RED);
        LogReg.add(editnotelp);

        labelnomor = new JLabel("Masukkan Nama Baru : ");
        labelnomor.setBounds(570, 400, 200, 30);
        LogReg.add(labelnomor);
        textnama = new JTextField();
        textnama.setBounds(570, 440, 200, 30);
        LogReg.add(textnama);
        editnama = new JButton("Edit");
        editnama.setBounds(770, 440, 100, 30);
        editnama.setBackground(Color.RED);
        LogReg.add(editnama);

        labelnomor = new JLabel(" Masukkan Alamat Baru :");
        labelnomor.setBounds(570, 480, 200, 30);
        LogReg.add(labelnomor);
        textalamat = new JTextField();
        textalamat.setBounds(570, 520, 200, 30);
        LogReg.add(textalamat);
        editalamat = new JButton("Edit");
        editalamat.setBounds(770, 520, 100, 30);
        editalamat.setBackground(Color.RED);
        LogReg.add(editalamat);

        labelhapus = new JLabel("Hapus User");
        labelhapus.setFont(new Font("Times New Roman", 1, 20));
        labelhapus.setBounds(170, 370, 210, 100);
        LogReg.add(labelhapus);

        labelusername = new JLabel("Masukkan Username : ");
        labelusername.setBounds(170, 430, 200, 30);
        LogReg.add(labelusername);
        textusername = new JTextField();
        textusername.setBounds(170, 460, 200, 30);
        LogReg.add(textusername);

        hapus = new JButton("Hapus");
        hapus.setBounds(400, 460, 100, 30);
        hapus.setBackground(Color.RED);
        LogReg.add(hapus);

        exit = new JButton("Keluar");
        exit.setBounds(370, 510, 100, 30);
        exit.setBackground(Color.RED);
        LogReg.add(exit);

        LogReg.setDefaultCloseOperation(3);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo((Component) null);
        editusername.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String uod = textcari.getText();
                    String usernameBr = textbaru.getText();
                    AllObjectController.user.editUsername(usernameBr,uod);
                    JOptionPane.showMessageDialog((Component)null, " Data Berhasil Diedit ", "information", 1);
                    new adminGUI();
                    LogReg.dispose();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog((Component)null, "Username Tidak Ada", "information", 1);
                    kosong();
                }
            }
        });
        editnama.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String uod = textcari.getText();
                    String namaBr = textnama.getText();
                    AllObjectController.user.editNama(namaBr,uod);
                    JOptionPane.showMessageDialog((Component)null, " Data Berhasil Diedit ", "information", 1);
                    new adminGUI();
                    LogReg.dispose();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog((Component)null, "Username Tidak Ada", "information", 1);
                    kosong();
                }
            }
        });
        editnotelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String uod = textcari.getText();
                    String notelpBr = textnotelp.getText();
                    AllObjectController.user.editNoTelp(notelpBr,uod);
                    JOptionPane.showMessageDialog((Component)null, " Data Berhasil Diedit ", "information", 1);
                    new adminGUI();
                    LogReg.dispose();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog((Component)null, "Username Tidak Ada", "information", 1);
                    kosong();
                }
            }
        });
        editalamat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String uod = textcari.getText();
                    String alamatBr = textalamat.getText();
                    AllObjectController.user.editAlamat(alamatBr,uod);
                    JOptionPane.showMessageDialog((Component)null, " Data Berhasil Diedit ", "information", 1);
                    new adminGUI();
                    LogReg.dispose();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog((Component)null, "Username Tidak Ada", "information", 1);
                    kosong();
                }
            }
        });
        hapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = textusername.getText();
                    AllObjectController.user.Del(username);
                    JOptionPane.showMessageDialog((Component)null, " Data Berhasil Dihapus ", "information", 1);
                    new adminGUI();
                    LogReg.dispose();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog((Component)null, "Username Tidak Ada", "information", 1);
                    kosong();
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
        textusername.setText((String)null);
        textcari.setText(null);
        textnomor.setText((String)null);
        textbaru.setText((String)null);
    }
}