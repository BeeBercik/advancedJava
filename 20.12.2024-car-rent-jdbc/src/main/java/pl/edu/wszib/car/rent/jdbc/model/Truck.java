package pl.edu.wszib.car.rent.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Truck extends Vehicle {
    private int capacity;

    public Truck(String brand, String model, int year, String color, String plate, int capacity) {
        super(brand, model, color, plate, year, false);
        this.capacity = capacity;
    }

    public Truck(int id, String brand, String model,  String color, String plate, int year, boolean rent, int capacity) {
        super(brand, model, color, plate, year, rent);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + " Capacity: " + this.capacity;
    }
}
