package pl.edu.wszib.car.rent.jdbc.db;

import pl.edu.wszib.car.rent.jdbc.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> getVehicles();
    boolean rentVehicle(String plate);

//    default zeby stare klasy nie musialy nadpisywac (to funkcjonalnosc dla nowych, a nie chcemy nowego interf.)
    default void persist(Vehicle vehicle) {
        throw new UnsupportedOperationException();
    }
}
