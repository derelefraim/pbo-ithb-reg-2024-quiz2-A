package controller;

import java.sql.ResultSet;
import java.sql.Statement;

public class CheckLogin {
    public CheckLogin(String username, String password){
        checkLogin(username, password);
    }
    public boolean checkLogin(String username, String password){
        DatabaseHandler conn = new DatabaseHandler();
        try {
            conn.connect();
            String query = "SELECT * FROM users WHERE name = '"+ username + "'  AND password = '"+password + "'";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                System.out.println(rs.getString("title"));
                if (rs.getString("name") == username && rs.getString("password") == password) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
        }
        return false;
    }
}
