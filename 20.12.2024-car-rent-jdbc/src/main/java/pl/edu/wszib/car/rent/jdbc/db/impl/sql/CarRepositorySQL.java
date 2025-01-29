package pl.edu.wszib.car.rent.jdbc.db.impl.sql;

import lombok.Getter;
import pl.edu.wszib.car.rent.jdbc.db.ICarRepository;
import pl.edu.wszib.car.rent.jdbc.model.Car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarRepositorySQL implements ICarRepository {
    @Getter
    public static final CarRepositorySQL instance = new CarRepositorySQL();

    private final String SQL_GET_ALL_CARS = "SELECT * FROM cars";
    private final String SQL_UPDATE_CAR = "UPDATE cars SET rent = true WHERE plate = ? AND rent = false";

    private CarRepositorySQL() {}

    @Override
    public boolean rent(String plate) {
        try(PreparedStatement preparedStatement = Constants.CONNECTION.prepareStatement(this.SQL_UPDATE_CAR);) {

            preparedStatement.setString(1, plate);
            int updatedCarRows = preparedStatement.executeUpdate();

            return updatedCarRows == 1;
        } catch (SQLException e) {
            System.out.println("problem in RentVehicle");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Car> getAll() {
        try (Statement statement = Constants.CONNECTION.createStatement()) {
            List<Car> vehicles = new ArrayList<>();

            ResultSet rs =  statement.executeQuery(this.SQL_GET_ALL_CARS);
            while(rs.next()) {
                vehicles.add(new Car(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("color"),
                        rs.getString("plate"),
                        rs.getInt("year"),
                        rs.getBoolean("rent")
                ));
            }
            return vehicles;
        } catch(SQLException e) {
            System.out.println("Problem in getVehicles");
            e.printStackTrace();
        }

        return List.of();
    }
}
