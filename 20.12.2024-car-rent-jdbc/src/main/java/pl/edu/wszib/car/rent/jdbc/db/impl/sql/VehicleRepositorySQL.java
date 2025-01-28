package pl.edu.wszib.car.rent.jdbc.db.impl.sql;

import lombok.Getter;
import pl.edu.wszib.car.rent.jdbc.db.IVehicleRepository;
import pl.edu.wszib.car.rent.jdbc.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositorySQL implements IVehicleRepository {
    @Getter
    public static final VehicleRepositorySQL instance = new VehicleRepositorySQL();

    private final String SQL_UPDATE_CARS = "UPDATE cars SET rent = true WHERE plate = ? AND rent = false";
    private final String SQL_GET_ALL_CARS = "SELECT * FROM cars";

    private VehicleRepositorySQL() {
    }

    @Override
    public boolean rent(String plate) {
        if(!CarRepositorySQL.getInstance().rent(plate)) {
            return TruckRepositorySQL.getInstance().rent(plate);
        }

        return true;
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(CarRepositorySQL.getInstance().getAll());
        vehicles.addAll(TruckRepositorySQL.getInstance().getAll());

        return vehicles;
    }
}
