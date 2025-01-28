package pl.edu.wszib.car.rent.jdbc.db;

import pl.edu.wszib.car.rent.jdbc.model.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> getAll();
    boolean rent(String plate);
}
