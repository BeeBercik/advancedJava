package pl.edu.wszib.car.rent.jdbc.db.impl.sql;

import lombok.Getter;
import pl.edu.wszib.car.rent.jdbc.db.ICarRepository;
import pl.edu.wszib.car.rent.jdbc.db.ITruckRepository;
import pl.edu.wszib.car.rent.jdbc.db.IVehicleRepository;
import pl.edu.wszib.car.rent.jdbc.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositorySQL implements IVehicleRepository {

    @Getter
    public static final VehicleRepositorySQL instance = new VehicleRepositorySQL();

    private final ICarRepository carRepositorySQL = CarRepositorySQL.getInstance();
    private final ITruckRepository truckRepositorySQL = TruckRepositorySQL.getInstance();

    private VehicleRepositorySQL() {}

    @Override
    public boolean rent(String plate) {
        if(!this.carRepositorySQL.rent(plate)) {
            return this.truckRepositorySQL.rent(plate);
        }
        return true;
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(this.carRepositorySQL.getAll());
        vehicles.addAll(this.truckRepositorySQL.getAll());
        return vehicles;
    }
}
