package pl.edu.wszib.car.rent.db.impl.sql;

import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.List;

public class VehicleRepositorySQL implements IVehicleRepository {
    @Override
    public boolean rentVehicle(String plate) {
        return false;
    }

    @Override
    public void persist(Vehicle vehicle) {
        IVehicleRepository.super.persist(vehicle);
    }

    @Override
    public List<Vehicle> getVehicles() {
        return null;
    }
}
