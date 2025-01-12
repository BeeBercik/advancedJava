package pl.edu.wszib.car.rent.db.impl.sql;

import pl.edu.wszib.car.rent.db.IUserRepository;
import pl.edu.wszib.car.rent.model.User;

import java.util.List;
import java.util.Optional;

public class UserRepositorySQL implements IUserRepository {
    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void persist(User user) {

    }

    @Override
    public Optional<User> getUser(String login) {
        return Optional.empty();
    }
}
