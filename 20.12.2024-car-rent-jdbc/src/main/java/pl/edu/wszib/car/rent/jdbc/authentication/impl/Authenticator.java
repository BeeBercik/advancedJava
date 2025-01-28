package pl.edu.wszib.car.rent.jdbc.authentication.impl;

import lombok.Getter;
import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.car.rent.jdbc.authentication.IAuthenticator;
import pl.edu.wszib.car.rent.jdbc.db.IUserRepository;
import pl.edu.wszib.car.rent.jdbc.db.impl.sql.UserRepositorySQL;
import pl.edu.wszib.car.rent.jdbc.model.User;

import java.util.Optional;

public class Authenticator implements IAuthenticator {

    @Getter
    private static Authenticator instance = new Authenticator();

    private IUserRepository userRepository = UserRepositorySQL.getInstance();
    private final String seed = "78912136141147282059639986715062";

    private Authenticator() {}

    public boolean authenticate(User user) {
        Optional<User> userBox = this.userRepository.getUser(user.getLogin());

        return userBox.isPresent() &&
                userBox.get().getPassword().equals(DigestUtils.md5Hex(user.getPassword()+seed));
    }
}
