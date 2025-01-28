package pl.edu.wszib.car.rent.jdbc.db;

import pl.edu.wszib.car.rent.jdbc.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> getAll();
    boolean rent(String plate);
}
