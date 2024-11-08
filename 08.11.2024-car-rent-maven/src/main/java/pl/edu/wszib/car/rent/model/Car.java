package pl.edu.wszib.car.rent.model;

import lombok.*;

@Getter
@Setter
public class Car extends Vehicle {

    public Car(String brand, String model, int year, String color, String plate) {
        super(brand, model, color, plate, year, false);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Car)) {
            return false;
        }

        return ((Car) obj).getPlate().equals(this.getPlate());
    }
}
