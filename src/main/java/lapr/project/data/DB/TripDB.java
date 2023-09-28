package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.trip.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TripDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Trip trip = (Trip) object;
        boolean returnValue ;

        try {
            saveTripToDatabase(databaseConnection, trip);

            //Save changes.
            returnValue = true;

        } catch (SQLException ex) {
            Logger.getLogger(TripDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }


    private void saveTripToDatabase(DatabaseConnection databaseConnection,
                                    Trip trip) throws SQLException {
        String sqlCommand =
                "INSERT INTO TRIP (TRIP_ID, VEHICLE_ID, MMSI, DEPARTURE, ARRIVAL, DEPARTURE_DATE, ARRIVAL_DATE)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?,?)";

        executeTripStatementOnDatabase(databaseConnection, trip,
                sqlCommand);

    }


    private void executeTripStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Trip trip, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveTripPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveTripPreparedStatement.setInt(1, trip.getTripID());
        saveTripPreparedStatement.setString(2, trip.getVehicleID());
        saveTripPreparedStatement.setString(3, trip.getShipMMSI());
        saveTripPreparedStatement.setString(4, trip.getDeparture());
        saveTripPreparedStatement.setString(5, trip.getArrival());
        saveTripPreparedStatement.setString(6, trip.getDepartureDate().toString());
        saveTripPreparedStatement.setString(7, trip.getArrivalDate().toString());

        saveTripPreparedStatement.executeUpdate();
        saveTripPreparedStatement.close();
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }
}
