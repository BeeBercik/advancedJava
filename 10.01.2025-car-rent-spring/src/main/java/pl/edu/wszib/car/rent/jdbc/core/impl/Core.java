package pl.edu.wszib.car.rent.jdbc.core.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.jdbc.authentication.IAuthenticator;
import pl.edu.wszib.car.rent.jdbc.authentication.impl.Authenticator;
import pl.edu.wszib.car.rent.jdbc.core.ICore;
import pl.edu.wszib.car.rent.jdbc.db.IVehicleRepository;
import pl.edu.wszib.car.rent.jdbc.db.impl.sql.VehicleRepositorySQL;
import pl.edu.wszib.car.rent.jdbc.gui.impl.GUI;
import pl.edu.wszib.car.rent.jdbc.gui.IGUI;

@Component
@RequiredArgsConstructor
public class Core implements ICore {
    private final IVehicleRepository vehicleRepository;
    private final IGUI gui;
    private final IAuthenticator authenticator;

    public void run() {
        boolean running = false;
        int trys = 0;
        while(!running && trys < 3) {
            running = this.authenticator.authenticate(this.gui.askForCredentials());
            trys++;
        }
        while(running) {
            switch (this.gui.showMenuAndReadChoice()) {
                case "1":
                    this.gui.listVehicles();
                    break;
                case "2":
                    this.gui.showResultMessage(this.vehicleRepository.rent(this.gui.readPlate()));
                    break;
                case "3":
                    System.out.println("Exit");
                    running = false;
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
    }
}