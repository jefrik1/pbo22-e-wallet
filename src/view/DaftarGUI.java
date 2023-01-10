package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class DaftarGUI {
    JFrame LogReg = new JFrame();
    JLabel daftar, top;
    JTextField textnama, textnotelp, texttgllahir, textusernamedaftar, textalamat;
    JLabel labelnama, labelnotelp, labeltgllahir,labelalamat, labelusernamedaftar, labelpassworddaftar;
    JButton reg;
    JPasswordField passworddaftar;

    public DaftarGUI(){
        LogReg.setSize(500, 630);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.GRAY);
        daftar = new JLabel("Buat Akun");
        daftar.setFont(new Font("Times New Roman", Font.BOLD, 30));
        daftar.setBounds(170, 50, 150, 100);
        LogReg.add(daftar);
        labelusernamedaftar = new JLabel("Username");
        labelusernamedaftar.setBounds(50, 150, 100, 30);
        LogReg.add(labelusernamedaftar);
        textusernamedaftar = new JTextField();
        textusernamedaftar.setBounds(50, 180, 200, 30);
        LogReg.add(textusernamedaftar);
        labelnama = new JLabel("Nama");
        labelnama.setBounds(50, 210, 100, 30);
        LogReg.add(labelnama);
        textnama = new JTextField();
        textnama.setBounds(50, 240, 200, 30);
        LogReg.add(textnama);
        labelpassworddaftar = new JLabel("Password");
        labelpassworddaftar.setBounds(50, 270, 100, 30);
        LogReg.add(labelpassworddaftar);
        passworddaftar = new JPasswordField();
        passworddaftar.setBounds(50, 300, 200, 30);
        LogReg.add(passworddaftar);
        labelnotelp = new JLabel("No Telepon");
        labelnotelp.setBounds(50, 330, 100, 30);
        LogReg.add(labelnotelp);
        textnotelp = new JTextField();
        textnotelp.setBounds(50, 360, 200, 30);
        LogReg.add(textnotelp);
        labeltgllahir = new JLabel("tanggal Lahir (dd/mm/yyyy)");
        labeltgllahir.setBounds(50, 390, 200, 30);
        LogReg.add(labeltgllahir);
        texttgllahir = new JTextField();
        texttgllahir.setBounds(50, 420, 200, 30);
        LogReg.add(texttgllahir);
        labelalamat = new JLabel("Alamat");
        labelalamat.setBounds(50, 450, 200, 30);
        LogReg.add(labelalamat);
        textalamat = new JTextField();
        textalamat.setBounds(50, 480, 200, 30);
        LogReg.add(textalamat);
        reg = new JButton("Daftar");
        reg.setBounds(100, 520, 100, 40);
        reg.setBackground(Color.GREEN);
        LogReg.add(reg);
        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);

        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String username = textusernamedaftar.getText();
                    String password = passworddaftar.getText();
                    String nama = textnama.getText();
                    String alamat = textalamat.getText();
                    String noTelp = textnotelp.getText();
                    Date tgllahir = new Date(texttgllahir.getText());
                    AllObjectController.user.insert(nama, tgllahir, alamat, noTelp, username, password);
                    JOptionPane.showMessageDialog(null, "Registrasi Sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                    new GUI();
                    LogReg.dispose();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    void kosong() {
        textusernamedaftar.setText(null);
        passworddaftar.setText(null);
        textnama.setText(null);
        textnotelp.setText(null);
        texttgllahir.setText(null);
        textalamat.setText(null);
    }
}
