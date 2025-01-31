package pl.edu.wszib.car.rent.jdbc.db.impl.sql;

import lombok.Getter;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.jdbc.db.IUserRepository;
import pl.edu.wszib.car.rent.jdbc.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepositorySQL implements IUserRepository {

   private final String SQL_GET_ALL_USERS = "SELECT * FROM users";
   private final String SQL_GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";

    @Override
    public List<User> getUsers() {
       List<User> users = new ArrayList<>();
       try(PreparedStatement ps = Constants.CONNECTION.prepareStatement(this.SQL_GET_ALL_USERS)) {
           ResultSet rs = ps.executeQuery();
           while(rs.next()) {
               users.add(new User(
                       rs.getInt("id"),
                       rs.getString("login"),
                       rs.getString("password")));
           }
       } catch(SQLException e) {
           System.out.println("Problem in getUsers");
           e.printStackTrace();
       }

       return users;
    }

    @Override
    public Optional<User> getUser(String login) {
        try(PreparedStatement ps = Constants.CONNECTION.prepareStatement(this.SQL_GET_USER_BY_LOGIN)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return Optional.of(new User(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password")
            ));
        } catch(SQLException e) {
            System.out.println("Problem in getUser");
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
