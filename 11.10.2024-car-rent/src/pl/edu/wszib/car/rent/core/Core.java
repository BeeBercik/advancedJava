package pl.edu.wszib.car.rent.core;

import pl.edu.wszib.car.rent.db.CarRepository;
import pl.edu.wszib.car.rent.gui.GUIInterface;
import pl.edu.wszib.car.rent.gui.GUIv2;

public class Core {
    private CarRepository carRepository = CarRepository.getInstance();
    private GUIInterface gui = GUIv2.getInstance();
    private final static Core instance = new Core();

    private Core() {}

    public void run() {
        boolean running = true;
        while(running) {
            switch (this.gui.showMenuAndReadChoice()) {
                case "1":
                    this.gui.listCars(this.carRepository.getCars());
                    break;
                case "2":
                    this.gui.showResultMessage(this.carRepository.rentCar(this.gui.readPlate()));
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

    public static Core getInstance() {
        return Core.instance;
    }
}
