package pl.edu.wszib.car.rent.gui;

import pl.edu.wszib.car.rent.model.Car;

import java.util.List;

public interface GUIInterface {
    String showMenuAndReadChoice();
    void listCars(List<Car> cars);
    String readPlate();
    void showResultMessage(boolean result);
}
