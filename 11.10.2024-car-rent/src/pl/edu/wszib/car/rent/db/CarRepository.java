package pl.edu.wszib.car.rent.db;

import pl.edu.wszib.car.rent.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    List<Car> cars = new ArrayList<>();
    private static final CarRepository instance = new CarRepository();

    private CarRepository() {
        this.cars.add(new Car("Toyota", "Corolla",
                2022, "Black", "KR11"));
        this.cars.add(new Car("BMW", "5",
                2022, "Red", "KR22"));
        this.cars.add(new Car("AUDI", "A5",
                2024, "White", "KR33"));
        this.cars.add(new Car("Mercedes", "Corolla",
                2019, "Black", "KR44"));
        this.cars.add(new Car("Honda", "Civic",
                2020, "Black", "KR55"));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public boolean rentCar(String plate) {
        for(Car car : this.cars) {
            if(car.getPlate().equals(plate) && !car.isRent()) {
                car.setRent(true);
                return true;
            }
        }
        return false;
    }

    public static CarRepository getInstance() {
        return CarRepository.instance;
    }
}
