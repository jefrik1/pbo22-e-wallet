package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUImain {
    JFrame LogReg = new JFrame();
    JButton admin, user;
    JLabel login,top;

    public GUImain(){
        LogReg.setSize(480, 300);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.YELLOW);
        top = new JLabel("Selamat Datang");
        top.setBounds(100, 10, 600, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        LogReg.add(top);
        login = new JLabel("Login Sebagai");
        login.setBounds(175, 50, 200, 100);
        login.setFont(new Font("Times New Roman", Font.BOLD, 20));
        LogReg.add(login);

        admin = new JButton("ADMIN");
        admin.setBounds(100, 150, 100, 70);
        admin.setBackground(Color.RED);
        LogReg.add(admin);

        user = new JButton("USER");
        user.setBounds(280, 150, 100, 70);
        user.setBackground(Color.RED);
        LogReg.add(user);

        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);

        admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new LogGUI();
                LogReg.dispose();
            }
        });
        user.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new GUI();
                LogReg.dispose();
            }
        });
    }
}
