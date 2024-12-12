package view;


import javax.swing.*;

import controller.CheckLogin;
import controller.DatabaseHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class LoginView {
    public LoginView(){
        initLogin();
    }
    DatabaseHandler conn = new DatabaseHandler();
    public void initLogin(){
        JFrame frame = new JFrame("Login Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField();

        JButton loginButton = new JButton("Login");

        JLabel messageLabel = new JLabel("");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passText.getPassword());

                CheckLogin checkLogin = new CheckLogin(username, password);
                boolean hasil = checkLogin.checkLogin(username, password);
                
                if (hasil == true) {
                    JOptionPane.showMessageDialog(frame, "Login berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new MainMenuScreen();
                } else {
                    messageLabel.setText("Username atau password salah.");
                }
            }
        });

        panel.add(userLabel);
        panel.add(userText);
        panel.add(passLabel);
        panel.add(passText);
        panel.add(loginButton);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(messageLabel, BorderLayout.SOUTH);

        frame.setVisible(true);

    }
}
