package pl.edu.wszib.car.rent.jdbc.model;

public class Car extends Vehicle {

    public Car(String brand, String model, String color, String plate, int year) {
        super(brand, model, color, plate, year);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Car)) {
            return false;
        }

        return ((Car) obj).getPlate().equals(this.getPlate());
    }
}
