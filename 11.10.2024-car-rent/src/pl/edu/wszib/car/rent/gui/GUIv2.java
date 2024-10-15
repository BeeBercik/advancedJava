package pl.edu.wszib.car.rent.gui;

import pl.edu.wszib.car.rent.model.Car;

import java.util.List;
import java.util.Scanner;

public class GUIv2 implements GUIInterface {
    private Scanner scanner = new Scanner(System.in);

    public String showMenuAndReadChoice() {
        System.out.println("1. List cars");
        System.out.println("2. Rent cars");
        System.out.println("3. Exit");

        return scanner.nextLine();
    }

    public void listCars(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getBrand() + " " + car.getModel() + " " + car.getYear() +
                    " " + car.getColor() + " " + car.getPlate() + " " + car.isRent());
        }
    }

    public String readPlate() {
        System.out.println("Enter plate:");
        return scanner.nextLine();
    }

    public void showResultMessage(boolean result) {
        System.out.println(result ? "Success" : "Error");
    }
}

