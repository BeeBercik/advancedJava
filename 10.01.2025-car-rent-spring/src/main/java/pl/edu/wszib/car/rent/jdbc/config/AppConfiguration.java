package pl.edu.wszib.car.rent.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.car.rent.jdbc.db.ICarRepository;
import pl.edu.wszib.car.rent.jdbc.db.ITruckRepository;
import pl.edu.wszib.car.rent.jdbc.db.IVehicleRepository;
import pl.edu.wszib.car.rent.jdbc.db.impl.sql.VehicleRepositorySQL;

import java.util.Scanner;

@Configuration
@ComponentScan("pl.edu.wszib.car.rent.jdbc")
public class AppConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

//    @Bean // gdybym nie chcial pisac przy klazie VehicleRepositorySQL adnotacji @Component, tylko samemu zrobic z niej beana
//    public IVehicleRepository vehicleRepositorySQL(ICarRepository carRepositorySQ,
//                                                   ITruckRepository truckRepositorySQ) {
//        return new VehicleRepositorySQL(carRepositorySQ, truckRepositorySQ);
//    }
}
