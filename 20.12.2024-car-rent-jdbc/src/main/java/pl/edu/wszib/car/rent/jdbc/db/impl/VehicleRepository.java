package pl.edu.wszib.car.rent.jdbc.db.impl;

import pl.edu.wszib.car.rent.jdbc.db.IVehicleRepository;
import pl.edu.wszib.car.rent.jdbc.model.Car;
import pl.edu.wszib.car.rent.jdbc.model.Truck;
import pl.edu.wszib.car.rent.jdbc.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements IVehicleRepository {
    List<Vehicle> vehicles = new ArrayList<>();
    private static final VehicleRepository instance = new VehicleRepository();

    private VehicleRepository() {
        this.vehicles.add(new Car( "Toyota", "Corolla",
                "Black", "KR11", 2020));
        this.vehicles.add(new Car( "BMW", "5", "Red", "KR22", 2022));
        this.vehicles.add(new Car( "AUDI", "A5", "White", "KR33", 2024));
        this.vehicles.add(new Car("Mercedes", "Corolla",
                "Black", "KR44", 2021));
        this.vehicles.add(new Car( "Honda", "Civic", "Black", "KR55", 2019));
        this.vehicles.add(new Truck( "Volvo", "Super",
                2021, "Black", "KR666", 800));
    }

    public boolean rentVehicle(String plate) {
        return this.vehicles.stream()
                .filter(v -> v.getPlate().equals(plate))
                .filter(v -> !v.isRent())
                .peek(v -> v.setRent(true))
                .findFirst()
                .isPresent();
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public static VehicleRepository getInstance() {
        return VehicleRepository.instance;
    }
}
