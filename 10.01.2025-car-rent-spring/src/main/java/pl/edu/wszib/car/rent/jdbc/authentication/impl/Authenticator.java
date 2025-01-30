package pl.edu.wszib.car.rent.jdbc.authentication.impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.jdbc.authentication.IAuthenticator;
import pl.edu.wszib.car.rent.jdbc.db.IUserRepository;
import pl.edu.wszib.car.rent.jdbc.model.User;

import java.util.Optional;

@Component
//@RequiredArgsConstructor // albo tak
public class Authenticator implements IAuthenticator {
    private final IUserRepository userRepository;
    private final String seed = "78912136141147282059639986715062";

    @Autowired // nie trzeba
    public Authenticator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(User user) {
        Optional<User> userBox = this.userRepository.getUser(user.getLogin());
        return userBox.isPresent() &&
                userBox.get().getPassword().equals(DigestUtils.md5Hex(user.getPassword() + seed));
    }
}
