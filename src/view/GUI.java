package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class GUI {

    JFrame LogReg = new JFrame();
    JLabel top;
    JTextField textusername;
    JLabel labelusernamelogin, labelpasswordlogin;
    JButton check,exit,reg;
    JPasswordField passwordlogin;

    public GUI() {
        LogReg.setSize(400, 400);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.LIGHT_GRAY);
        top = new JLabel("USER");
        top.setBounds(150, 10, 600, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        LogReg.add(top);

        labelusernamelogin = new JLabel("Username");
        labelusernamelogin.setBounds(38, 80, 100, 30);
        LogReg.add(labelusernamelogin);
        textusername = new JTextField();
        textusername.setBounds(30, 120, 280, 30);
        LogReg.add(textusername);
        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds(39, 190, 100, 30);
        LogReg.add(labelpasswordlogin);
        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(30, 220, 280, 30);
        LogReg.add(passwordlogin);
        check = new JButton("Login");
        check.setBounds(150, 260, 100, 40);
        check.setBackground(Color.GREEN);
        LogReg.add(check);
        reg = new JButton("Registrasi");
        reg.setBounds(280, 320, 100, 40);
        reg.setBackground(Color.GREEN);
        LogReg.add(reg);
        exit = new JButton("Keluar");
        exit.setBounds(250, 530, 100, 30);
        exit.setBackground(Color.RED);
        LogReg.add(exit);
        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);

        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                try {
                    AllObjectController.user.login(textusername.getText(), passwordlogin.getText());
                    String nama = AllObjectController.user.userEntity().getUsername();
                    JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                    new userGUI();
                    LogReg.dispose();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Username atau password salah", " information", JOptionPane.INFORMATION_MESSAGE);
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
        reg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new DaftarGUI();
                LogReg.dispose();
            }
        });
    }


    void kosong() {
        textusername.setText(null);
        passwordlogin.setText(null);
    }
    }



