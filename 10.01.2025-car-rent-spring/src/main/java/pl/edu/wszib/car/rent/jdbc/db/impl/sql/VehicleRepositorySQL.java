package pl.edu.wszib.car.rent.jdbc.db.impl.sql;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.jdbc.db.ICarRepository;
import pl.edu.wszib.car.rent.jdbc.db.ITruckRepository;
import pl.edu.wszib.car.rent.jdbc.db.IVehicleRepository;
import pl.edu.wszib.car.rent.jdbc.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

// Qualifier("nazwa_beana") mozna przy polu z autowired dac, aby wskazac konkretnego beana, lub w konstruktorze przed polem rowniez wskazac beana ktory ma wstrzyknac (jesli oba np rozszerzaja ten sam interfejs)
// public GUI(Scanner scanner, @Qualifier("ala") IVehicleRepository vehicleRepository) {
//        this.scanner = scanner;
//        this.vehicleRepository = vehicleRepository;
//    }

@Component
//@Component("ala") // mozna nadac nazwe komponentowi
//@Primary // lub wskazac aby on byl pierwsze wstrzykiwany
@RequiredArgsConstructor
public class VehicleRepositorySQL implements IVehicleRepository {

    private final ICarRepository carRepositorySQL;
    private final ITruckRepository truckRepositorySQL;

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
