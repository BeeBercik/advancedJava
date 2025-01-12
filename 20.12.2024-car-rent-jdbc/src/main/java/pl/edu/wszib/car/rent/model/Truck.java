package pl.edu.wszib.car.rent.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Truck extends Vehicle {
    private int capacity;

    public Truck(int id, String brand, String model, int year, String color, String plate, int capacity) {
        super(id, brand, model, color, plate, year, false);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + " Capacity: " + this.capacity;
    }
}
