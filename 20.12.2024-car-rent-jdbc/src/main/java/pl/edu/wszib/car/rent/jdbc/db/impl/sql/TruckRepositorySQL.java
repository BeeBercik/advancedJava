package pl.edu.wszib.car.rent.jdbc.db.impl.sql;

import lombok.Getter;
import pl.edu.wszib.car.rent.jdbc.db.ITruckRepository;
import pl.edu.wszib.car.rent.jdbc.model.Truck;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TruckRepositorySQL implements ITruckRepository {

    @Getter
    public static final TruckRepositorySQL instance = new TruckRepositorySQL();

    private final String SQL_GET_ALL_TRUCKS = "SELECT * FROM trucks";
    private final String SQL_UPDATE_TRUCK = "UPDATE trucks SET rent = true WHERE plate = ? AND rent = false";

    private TruckRepositorySQL() {}

    @Override
    public boolean rent(String plate) {
        try(PreparedStatement preparedStatement = Constants.CONNECTION.prepareStatement(this.SQL_UPDATE_TRUCK);) {

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
    public List<Truck> getAll() {
        try (Statement statement = Constants.CONNECTION.createStatement()) {
            List<Truck> vehicles = new ArrayList<>();

            ResultSet rs =  statement.executeQuery(this.SQL_GET_ALL_TRUCKS);
            while(rs.next()) {
                vehicles.add(new Truck(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("color"),
                        rs.getString("plate"),
                        rs.getInt("year"),
                        rs.getBoolean("rent"),
                        rs.getInt("capacity")
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
