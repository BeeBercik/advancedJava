package pl.edu.wszib.car.rent.jdbc.gui.impl;

import pl.edu.wszib.car.rent.jdbc.db.IVehicleRepository;
import pl.edu.wszib.car.rent.jdbc.db.impl.sql.VehicleRepositorySQL;
import pl.edu.wszib.car.rent.jdbc.gui.IGUI;
import pl.edu.wszib.car.rent.jdbc.model.User;

import java.util.Scanner;

public class GUI implements IGUI {
    private final Scanner scanner = new Scanner(System.in);
    private final static GUI instance = new GUI();
    private final IVehicleRepository vehicleRepository = VehicleRepositorySQL.getInstance();

    private GUI() {}

    public String showMenuAndReadChoice() {
        System.out.println("1. List cars");
        System.out.println("2. Rent cars");
        System.out.println("3. Exit");

        return scanner.nextLine();
    }

    public void listVehicles() {
        this.vehicleRepository.getAll().forEach(System.out::println);
    }

    public String readPlate() {
        System.out.println("Enter plate:");
        return scanner.nextLine();
    }

    public void showResultMessage(boolean result) {
        System.out.println(result ? "Success" : "Error");
    }

    @Override
    public User askForCredentials() {
        System.out.println("Enter login:");
        String login = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        return new User(login, password);
    }

    public static GUI getInstance() {
        return GUI.instance;
    }
}
