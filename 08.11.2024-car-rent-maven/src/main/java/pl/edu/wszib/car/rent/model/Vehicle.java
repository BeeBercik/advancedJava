package pl.edu.wszib.car.rent.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    protected String brand;
    protected String model;
    protected String color;
    protected String plate;
    protected int year;
    protected boolean rent;

    @Override
    public String toString() {
        return new StringBuilder().append(this.getBrand() + " "  +
                this.getModel() + " "  + this.getColor() + " " + this.getPlate() + " "  + this.getYear() + " " +
                (this.isRent() ? "Not available" : "Available")).toString();
    }
}
