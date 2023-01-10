package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class LogGUI {

    JFrame LogReg = new JFrame();
    JLabel login, top;
    JTextField textusername;
    JLabel labelusernamelogin,labelpasswordlogin;
    JButton check;
    JPasswordField passwordlogin;

    public LogGUI() {
        LogReg.setSize(400, 400);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.PINK);
        top = new JLabel("Admin");
        top.setBounds(130, 10, 600, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        LogReg.add(top);
        login = new JLabel("login");
        login.setBounds(150, 70, 100, 50);
        login.setFont(new Font("Times New Roman", Font.BOLD, 30));
        LogReg.add(login);

        labelusernamelogin = new JLabel("Username");
        labelusernamelogin.setBounds(38, 120, 100, 30);
        LogReg.add(labelusernamelogin);
        textusername = new JTextField();
        textusername.setBounds(30, 150, 200, 30);
        LogReg.add(textusername);
        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds(39, 210, 100, 30);
        LogReg.add(labelpasswordlogin);
        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(30, 240, 280, 36);
        LogReg.add(passwordlogin);
        check = new JButton("Login");
        check.setBounds(90, 290, 180, 40);
        check.setBackground(Color.GREEN);
        LogReg.add(check);

        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);

        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                    try {
                        AllObjectController.admin.dataAdmin();
                        AllObjectController.admin.login(textusername.getText(), passwordlogin.getText());
                        String nama = AllObjectController.admin.adminEntity().getUsername();
                        JOptionPane.showMessageDialog(null, "selamat datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        new adminGUI();
                        LogReg.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "NPM atau password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
            }
        });
    }
    void kosong() {
        textusername.setText(null);
        passwordlogin.setText(null);
    }
}



