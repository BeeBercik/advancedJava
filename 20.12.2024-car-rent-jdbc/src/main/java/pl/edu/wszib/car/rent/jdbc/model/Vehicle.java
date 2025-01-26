package pl.edu.wszib.car.rent.jdbc.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle {
    protected int id;
    protected String brand;
    protected String model;
    protected String color;
    protected String plate;
    protected int year;
    protected boolean rent;

    public Vehicle(String brand, String model, String color, String plate, int year) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.plate = plate;
        this.year = year;
        this.rent = false;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.getBrand() + " "  +
                this.getModel() + " "  + this.getColor() + " " + this.getPlate() + " "  + this.getYear() + " " +
                (this.isRent() ? "Not-available" : "Available")).toString();
    }
}
