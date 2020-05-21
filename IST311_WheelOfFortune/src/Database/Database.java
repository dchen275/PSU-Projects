package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iljaz (ijt5038@psu.edu)
 * @author David Chen (dkc5318@psu.edu)
 */
public class Database {
    final static String DATABASE_URL = "jdbc:derby://localhost:1527/sample";
    public static List<String> getAllPuzzles() {
        List<String> names = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, "app", "app")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CUSTOMER");
            while (resultSet.next()) {
                names.add((String) resultSet.getObject("NAME"));
            }
            return names;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
