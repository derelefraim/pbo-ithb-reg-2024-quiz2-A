package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MainMenuScreen {
    
    public MainMenuScreen() {
        initComponents();
    }
    
    private void initComponents() {
        
        JFrame mainFrame = new JFrame("MAIN MENU");

        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(300, 150);
        mainFrame.setLocationRelativeTo(null); 
        
        JButton loginButton = new JButton("Login");
        JButton bookListButton = new JButton("Book List");
        JButton transButton = new JButton("Transaction");
        
        loginButton.addActionListener(e -> {
            mainFrame.dispose();
                new LoginView();
        });

        bookListButton.addActionListener(e -> {
            mainFrame.dispose();
            new ShowBooks();
        });

        transButton.addActionListener(e -> {
            // mainFrame.dispose();
        });
        
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(loginButton);
        mainPanel.add(bookListButton);
        mainPanel.add(transButton);
        
        mainFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }
}
