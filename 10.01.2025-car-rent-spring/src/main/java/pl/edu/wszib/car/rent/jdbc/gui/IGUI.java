package pl.edu.wszib.car.rent.jdbc.gui;

import pl.edu.wszib.car.rent.jdbc.model.User;

public interface IGUI {
    String showMenuAndReadChoice();
    void listVehicles();
    String readPlate();
    void showResultMessage(boolean result);
    User askForCredentials();
}
