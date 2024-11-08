package pl.edu.wszib.car.rent.db;

import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> getVehicles();
    boolean rentVehicle(String plate);
}
