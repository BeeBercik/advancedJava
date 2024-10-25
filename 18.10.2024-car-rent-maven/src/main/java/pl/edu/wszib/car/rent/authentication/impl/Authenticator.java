package pl.edu.wszib.car.rent.authentication.impl;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.car.rent.authentication.IAuthenticator;
import pl.edu.wszib.car.rent.db.impl.UserRepository;
import pl.edu.wszib.car.rent.model.User;

public class Authenticator implements IAuthenticator {
    private String seed = "78912136141147282059639986715062";
    private UserRepository userRepository = UserRepository.getInstance();
    private static Authenticator instance = new Authenticator();

    private Authenticator() {}

    public boolean authenticate(User user) {
        User userFromDb = this.userRepository.getUser(user.getLogin());
        return userFromDb != null &&
                userFromDb.getPassword().equals(DigestUtils.md5Hex(user.getPassword()+seed));
    }

    public static Authenticator getInstance() {
        return Authenticator.instance;
    }
}
