package pl.edu.wszib.car.rent.jdbc.db;

import pl.edu.wszib.car.rent.jdbc.model.Truck;

import java.util.List;

public interface ITruckRepository {
    List<Truck> getAll();
    boolean rent(String plate);
}
