package pl.edu.wszib.car.rent.db.impl;

import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.Truck;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements IVehicleRepository {
    List<Vehicle> vehicles = new ArrayList<>();
    private static final VehicleRepository instance = new VehicleRepository();

    private VehicleRepository() {
        this.vehicles.add(new Car("Toyota", "Corolla",
                2022, "Black", "KR11"));
        this.vehicles.add(new Car("BMW", "5",
                2022, "Red", "KR22"));
        this.vehicles.add(new Car("AUDI", "A5",
                2024, "White", "KR33"));
        this.vehicles.add(new Car("Mercedes", "Corolla",
                2019, "Black", "KR44"));
        this.vehicles.add(new Car("Honda", "Civic",
                2020, "Black", "KR55"));
        this.vehicles.add(new Truck("Volvo", "Super",
                2021, "Black", "KR666", 800));
    }

    public boolean rentVehicle(String plate) {
        for(Vehicle car : this.vehicles) {
            if(car.getPlate().equals(plate) && !car.isRent()) {
                car.setRent(true);
                return true;
            }
        }
        return false;
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public static VehicleRepository getInstance() {
        return VehicleRepository.instance;
    }
}
