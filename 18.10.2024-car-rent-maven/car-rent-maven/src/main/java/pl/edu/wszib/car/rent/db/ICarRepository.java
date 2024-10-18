package pl.edu.wszib.car.rent.db;

import pl.edu.wszib.car.rent.model.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> getCars();
    boolean rentCar(String plate);
}
