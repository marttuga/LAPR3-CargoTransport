package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.Vehicle.Vehicle;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Vehicle vehicle = (Vehicle) object;
        boolean returnValue ;

        try {
            saveVehicleToDatabase(databaseConnection, vehicle);

            //Save changes.
            returnValue = true;

        } catch (SQLException ex) {
            Logger.getLogger(VehicleDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }


    private void saveVehicleToDatabase(DatabaseConnection databaseConnection,
                                    Vehicle vehicle) throws SQLException {
        String sqlCommand =
                "INSERT INTO VEHICLE (VEHICLE_ID)\n" +
                        "VALUES (?)";

        executeVehicleStatementOnDatabase(databaseConnection, vehicle,
                sqlCommand);

    }


    private void executeVehicleStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Vehicle vehicle, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveVehiclePreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveVehiclePreparedStatement.setString(1, vehicle.getVehicleID());
        saveVehiclePreparedStatement.executeUpdate();
        saveVehiclePreparedStatement.close();
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }
}

