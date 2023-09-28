package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.ship.Ship;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShipDB implements Persistable {

    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Ship ship = (Ship) object;
        boolean returnValue ;

        try {
            saveShipToDatabase(databaseConnection, ship);

            //Save changes.
            returnValue = true;

        } catch (SQLException ex) {
            Logger.getLogger(ShipDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection,
                          Object object) {
        boolean returnValue;
        Connection connection = databaseConnection.getConnection();
        Ship ship = (Ship) object;
        try {
            String sqlCommand;

            sqlCommand = "delete from ship where mmsi = ?";
            try (PreparedStatement deleteShipPreparedStatement = connection.prepareStatement(
                    sqlCommand)) {
                deleteShipPreparedStatement.setInt(1, ship.getmMSI());
                deleteShipPreparedStatement.executeUpdate();
            }

            returnValue = true;

        } catch (SQLException exception) {
            Logger.getLogger(ShipDB.class.getName())
                    .log(Level.SEVERE, null, exception);
            databaseConnection
                    .registerError(exception);
            returnValue = false;
        }
        return returnValue;
    }


    private void saveShipToDatabase(DatabaseConnection databaseConnection,
                                    Ship ship) throws SQLException {
        if (isShipOnDatabase(databaseConnection, ship)) {
            updateShipOnDatabase(databaseConnection, ship);
        } else {
            insertShipOnDatabase(databaseConnection, ship);
        }

    }


    private boolean isShipOnDatabase(DatabaseConnection databaseConnection,
                                     Ship ship) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        boolean isShipOnDatabase;

        String sqlCommand = "select * from ship where MMSI = ?";

        PreparedStatement getShipsPreparedStatement =
                connection.prepareStatement(sqlCommand);

        getShipsPreparedStatement.setInt(1, ship.getmMSI());

        try (ResultSet shipsResultSet = getShipsPreparedStatement.executeQuery()) {

            if (shipsResultSet.next()) {
                // if client already exists in the database
                isShipOnDatabase = true;
            } else {

                // if client does not exist in the database
                isShipOnDatabase = false;
            }
        }

        return isShipOnDatabase;
    }


    private void insertShipOnDatabase(DatabaseConnection databaseConnection,
                                      Ship ship) throws SQLException {
        String sqlCommand =
                "INSERT INTO SHIP (MMSI, IMO, CALLSIGN, VESSEL_TYPE, NAME, CAPACITY, DRAFT, WIDTH, LENGTH ,NUM_GENERATORS, VEHICLE_ID)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        executeShipStatementOnDatabase(databaseConnection, ship,
                sqlCommand);

    }


    private void updateShipOnDatabase(DatabaseConnection databaseConnection,
                                      Ship ship) throws SQLException {
        String sqlCommand =
                "UPDATE SHIP SET NUM_GENERATORS = ? WHERE MMSI = ?";

        executeShipUpdateOnDatabase(databaseConnection, ship,
                sqlCommand);
    }


    private void executeShipStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Ship ship, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveShipPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveShipPreparedStatement.setInt(1, ship.getmMSI());
        saveShipPreparedStatement.setString(2, ship.getiMO());
        saveShipPreparedStatement.setString(3, ship.getCallSign());
        saveShipPreparedStatement.setInt(4, ship.getVesselType());
        saveShipPreparedStatement.setString(5, ship.getVesselName());
        saveShipPreparedStatement.setInt(6, 20);
        saveShipPreparedStatement.setDouble(7, ship.getDraft());
        saveShipPreparedStatement.setInt(8, ship.getWidth());
        saveShipPreparedStatement.setInt(9, ship.getLength());
        saveShipPreparedStatement.setInt(10, 2);
        saveShipPreparedStatement.setString(11, ship.getVehicleID());
        saveShipPreparedStatement.executeUpdate();
        saveShipPreparedStatement.close();
        

    }

    private void executeShipUpdateOnDatabase(
            DatabaseConnection databaseConnection,
            Ship ship, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveShipPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveShipPreparedStatement.setInt(1, 3);
        saveShipPreparedStatement.setInt(2, ship.getmMSI());
        saveShipPreparedStatement.executeUpdate();
        saveShipPreparedStatement.close();
    }

}
