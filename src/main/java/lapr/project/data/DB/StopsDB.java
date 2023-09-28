package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.trip.Stops;
import lapr.project.model.trip.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StopsDB implements Persistable {

    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Stops stops = (Stops) object;
        boolean returnValue ;

        try {
            saveStopsToDatabase(databaseConnection, stops);

            //Save changes.
            returnValue = true;

        } catch (SQLException ex) {
            Logger.getLogger(StopsDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    private void saveStopsToDatabase(DatabaseConnection databaseConnection,
                                    Stops stops) throws SQLException {
        String sqlCommand =
                "INSERT INTO STOPS (STOPS_NAME,TRIP_ID,STOPS_ARRIVAL_DATE,STOPS_DEPARTURE_DATE)\n" +
                        "VALUES (?, ?,?,?)";

        executeStopsStatementOnDatabase(databaseConnection, stops,
                sqlCommand);

    }


    private void executeStopsStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Stops stops, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveStopsPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveStopsPreparedStatement.setString(1, stops.getName());
        saveStopsPreparedStatement.setInt(2, stops.getTripID());
        saveStopsPreparedStatement.setString(3, stops.getDepartureDateStops().toString());
        saveStopsPreparedStatement.setString(4, stops.getArrivalDateStops().toString());
        saveStopsPreparedStatement.executeUpdate();
        saveStopsPreparedStatement.close();

    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }
}
