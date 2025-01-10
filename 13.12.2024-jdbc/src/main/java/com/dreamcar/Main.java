package com.dreamcar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// DriverManager - klasa odp. za zarzadzanie sterownikami bazdy danych np. nawiazuje polaczenie
// .executeQuery() gdy select
// .executeUpdate() gdy modifykuje stan np update, insert, delete
// PreparedStatement jest wielokrotnego uzytku, zwykly statement nie

public class Main {
    public static Connection connection;

    public static void main(String[] args) {
        Main.connect();
//        Optional<User> userBox = Main.getUserById(2);
//        userBox.ifPresentOrElse(System.out::println, () -> System.out.println("Nie ma"));
//
//        User wera = new User("rob", "rob123", "robert");
//        Main.persistUser(wera);

//        Main.deleteUser(1);

//        User mUser = Main.getUserById(3).get();
//        mUser.setName("robus");
//        Main.updateUser(mUser);

        List<User> users = Main.getAllUsers();
        for(User user : users) {
            System.out.println(user);
        }

        Main.disconnect();
    }

    public static void connect() {
        String url = "jdbc:mysql://localhost:3306/advanced_java";
        String username = "root";
        String password = "";

        try {
            Main.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Połączono z bazą danych!");
        } catch (SQLException e) {
            System.err.println("Nie udało się połączyć z bazą danych.");
            e.printStackTrace();
        }
    }

    public static void persistUser(User user) {
        try {
            String sql = "INSERT INTO users (login, password, name) VALUES (?, ?, ? )";
            PreparedStatement preparedStatement = Main.connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());

            preparedStatement.executeUpdate();

//            preparedStatement.clearParameters();  // reuzywalne
//            preparedStatement.setString(1, "a");
//            preparedStatement.setString(2, "b");
//            preparedStatement.setString(3, "c");

        } catch (SQLException e) {
            System.out.println("Error: persisUser " + e.getMessage());
        }
    }

    public static void updateUser(User user) {
        try {
            String sql = "UPDATE users SET login = ?, password = ?, name = ? WHERE id = ?";
            PreparedStatement ps = Main.connection.prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: updateUser " + e.getMessage());
        }
    }

    public static void deleteUser(int id) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = Main.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: deleteUser " + e.getMessage());
        }
    }

    public static Optional<User> getUserById(int id) {
        try {
            String sql = "SELECT * FROM users WHERE id = " + id;
            Statement statement = Main.connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next()) {
                return Optional.of(new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("name")));
            }
        } catch (SQLException e) {
            System.out.println("Error: getUserById: " + e.getMessage());
        }

        return Optional.empty();
    }

    public static List<User> getAllUsers() {
        try {
            String sql = "SELECT * FROM users";
            ResultSet rs = Main.connection.prepareStatement(sql).executeQuery();

            List<User> users = new ArrayList<>();
            while(rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("name")));
            }

            return users;
        } catch(SQLException e) {
            System.out.println("Error: getAllUsers: " + e.getMessage());
        }

        return List.of();
    }

    public static void disconnect() {
        try {
            Main.connection.close();
        } catch(SQLException e) {
            System.out.println("Error: disconnect: " + e.getMessage());
        }
    }
}
