package pl.edu.wszib.car.rent.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Constants {
    Connection CONNECTION = Constants.connect();

     static Connection connect() {
         try {
             String url = "jdbc:mysql://localhost:3306/advanced_java";
             String user = "root";
             String password = "";

             return DriverManager.getConnection(url, user, password);
         } catch(SQLException e) {
             e.printStackTrace();
         }
         return null;
    }
}
