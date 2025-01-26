package pl.edu.wszib.car.rent.jdbc.db.impl.sql;

import lombok.Getter;
import pl.edu.wszib.car.rent.jdbc.db.IVehicleRepository;
import pl.edu.wszib.car.rent.jdbc.model.Vehicle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepositorySQL implements IVehicleRepository {
    @Getter
    public static final VehicleRepositorySQL instance = new VehicleRepositorySQL();

    private final String SQL_UPDATE = "UPDATE cars SET rent = true WHERE plate = ? AND rent = false";
    private final String SQL_GET_ALL = "SELECT * FROM cars";

    private VehicleRepositorySQL() {
    }

    @Override
    public boolean rent(String plate) {
        try(
                PreparedStatement preparedStatement = Constants.CONNECTION.prepareStatement(this.SQL_UPDATE);) {
            preparedStatement.setString(1, plate);
            int updatedRows = preparedStatement.executeUpdate();

            return updatedRows == 1;
        } catch (SQLException e) {
            System.out.println("problem in RentVehicle");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Vehicle> getAll() {
        try (Statement statement = Constants.CONNECTION.createStatement()) {
            List<Vehicle> vehicles = new ArrayList<>();

            ResultSet rs =  statement.executeQuery(this.SQL_GET_ALL);
            while(rs.next()) {
                vehicles.add(new Vehicle(
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
