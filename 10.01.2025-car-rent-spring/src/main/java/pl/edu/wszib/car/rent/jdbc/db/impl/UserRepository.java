package pl.edu.wszib.car.rent.jdbc.db.impl;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.car.rent.jdbc.db.IUserRepository;
import pl.edu.wszib.car.rent.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository {
    List<User> users = new ArrayList<>();
    private static UserRepository instance = new UserRepository();

    private UserRepository() {
        this.users.add(new User(1, "admin",
                DigestUtils.md5Hex("admin78912136141147282059639986715062")));
        this.users.add(new User(2, "janusz",
                DigestUtils.md5Hex("robert78912136141147282059639986715062")));
    }

    public Optional<User> getUser(String login) {
        return this.users.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
    }

    public List<User> getUsers() {
        return this.users;
    }

    public static UserRepository getInstance() {
        return UserRepository.instance;
    }
}
