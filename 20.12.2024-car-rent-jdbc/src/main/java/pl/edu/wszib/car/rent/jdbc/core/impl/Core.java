package pl.edu.wszib.car.rent.jdbc.core.impl;

import lombok.Getter;
import pl.edu.wszib.car.rent.jdbc.authentication.IAuthenticator;
import pl.edu.wszib.car.rent.jdbc.authentication.impl.Authenticator;
import pl.edu.wszib.car.rent.jdbc.core.ICore;
import pl.edu.wszib.car.rent.jdbc.db.IVehicleRepository;
import pl.edu.wszib.car.rent.jdbc.db.impl.sql.VehicleRepositorySQL;
import pl.edu.wszib.car.rent.jdbc.gui.impl.GUI;
import pl.edu.wszib.car.rent.jdbc.gui.IGUI;

public class Core implements ICore {
    @Getter
    private final static Core instance = new Core();

    private final IVehicleRepository vehicleRepository = VehicleRepositorySQL.getInstance();
    private final IGUI gui = GUI.getInstance();
    private final IAuthenticator authenticator = Authenticator.getInstance();

    private Core() {}

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