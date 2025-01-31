package pl.edu.wszib.car.rent.jdbc.authentication;

import pl.edu.wszib.car.rent.jdbc.model.User;

public interface IAuthenticator {
    boolean authenticate(User user);
}
