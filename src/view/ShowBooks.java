package view;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

import controller.DatabaseHandler;

public class ShowBooks {
    public ShowBooks() {
        initshowBooks();
    }

    DatabaseHandler con = new DatabaseHandler();

    public void initshowBooks() {
        try {
            con.connect();
            String query = "SELECT * FROM books WHERE";
            Statement stmt = con.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                System.out.println(rs.getString("title"));
            }

            JFrame frame = new JFrame("List Bukku");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 1));

            JLabel label1 = new JLabel("Text 1: " + rs.getString("title"));
            JLabel label2 = new JLabel("Text 2: " + rs.getString("author"));
            JLabel label3 = new JLabel("Text 3: " + rs.getString("genre"));

            panel.add(label1);
            panel.add(label2);
            panel.add(label3);

            frame.add(panel);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
