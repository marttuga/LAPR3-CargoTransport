package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.Truck.Truck;
import lapr.project.model.trip.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TruckDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Truck truck = (Truck) object;
        boolean returnValue ;

        try {
            saveTruckToDatabase(databaseConnection, truck);

            //Save changes.
            returnValue = true;

        } catch (SQLException ex) {
            Logger.getLogger(TruckDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    private void saveTruckToDatabase(DatabaseConnection databaseConnection,
                                    Truck truck) throws SQLException {
        String sqlCommand =
                "INSERT INTO TRUCK(TRUCK_ID,NAME, LICENSE_PLATE )\n" +
                        "VALUES(?, ?, ?)";

        executeTruckStatementOnDatabase(databaseConnection, truck,
                sqlCommand);

    }


    private void executeTruckStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Truck truck, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveTruckPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveTruckPreparedStatement.setInt(1, truck.getTruckID());
        saveTruckPreparedStatement.setString(2, truck.getName());
        saveTruckPreparedStatement.setInt(3, truck.getLicensePlate());
        saveTruckPreparedStatement.executeUpdate();
        saveTruckPreparedStatement.close();
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }
}
