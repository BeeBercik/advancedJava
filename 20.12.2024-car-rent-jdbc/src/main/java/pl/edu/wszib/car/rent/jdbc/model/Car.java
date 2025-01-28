package pl.edu.wszib.car.rent.jdbc.model;

public class Car extends Vehicle {

    public Car(String brand, String model, String color, String plate, int year) {
        super(brand, model, color, plate, year, false);
    }

    public Car(int id, String brand, String model, String color, String plate, int year, boolean rent) {
        super(brand, model, color, plate, year, rent);
    }
}
