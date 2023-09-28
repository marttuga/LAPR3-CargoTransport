package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.Location.Location;
import lapr.project.model.intermediateClasses.ShipLocation;
import lapr.project.model.port.Port;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocationDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Location location = (Location) object;
        boolean returnValue = false;

        try {
            saveLocationToDatabase(databaseConnection, location);
            returnValue = true;
        }catch (SQLException ex) {
            Logger.getLogger(LocationDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }

    private void saveLocationToDatabase(DatabaseConnection databaseConnection,
                                        Location location) throws SQLException {

        if (isLocationOnDatabase(databaseConnection, location)) {
            updateLocationOnDatabase(databaseConnection, location);
        } else {
            insertLocationOnDatabase(databaseConnection, location);
        }

    }

    private boolean isLocationOnDatabase(DatabaseConnection databaseConnection,
                                         Location location) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        boolean isLocationOnDatabase;

        String sqlCommand = "select * from location where location_id = ?";

        PreparedStatement getLocationPreparedStatement =
                connection.prepareStatement(sqlCommand);

        getLocationPreparedStatement.setString(1, location.getLocationID());

        try (ResultSet locationResultSet = getLocationPreparedStatement.executeQuery()) {

            if (locationResultSet.next()) {
                // if client already exists in the database
                isLocationOnDatabase = true;
            } else {

                // if client does not exist in the database
                isLocationOnDatabase = false;
            }
        }
        return isLocationOnDatabase;
    }


    private void insertLocationOnDatabase(DatabaseConnection databaseConnection,
                                          Location location) throws SQLException {
        String sqlCommand =
                "INSERT INTO LOCATION(LOCATION_ID, TYPE, NAME, POSITION_ID, COUNTRY, TRIP_ID, CAPACITY)\n" +
                        "VALUES(?, ?, ?, ?, ?, ?, ?)";

        executeLocationStatementOnDatabase(databaseConnection, location,
                sqlCommand);
    }


    private void updateLocationOnDatabase(DatabaseConnection databaseConnection,
                                          Location location) throws SQLException {
        String sqlCommand =
                "UPDATE LOCATION SET NAME = ? WHERE LOCATION_ID = ?";

        executeLocationUpdateOnDatabase(databaseConnection, location,
                sqlCommand);
    }


    private void executeLocationStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Location location, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveLocationPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveLocationPreparedStatement.setString(1, location.getLocationID());
        saveLocationPreparedStatement.setString(2,location.getType());
        saveLocationPreparedStatement.setString(3,location.getName());
        saveLocationPreparedStatement.setInt(4,location.getPositionID());
        saveLocationPreparedStatement.setString(5,location.getCountry());
        saveLocationPreparedStatement.setInt(6,location.getTripID());
        saveLocationPreparedStatement.setInt(7,location.getCapacity());
        saveLocationPreparedStatement.executeUpdate();
        saveLocationPreparedStatement.close();
    }

    private void executeLocationUpdateOnDatabase(
            DatabaseConnection databaseConnection,
            Location location, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveLocationPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveLocationPreparedStatement.setString(1,location.getName());
        saveLocationPreparedStatement.setString(2,location.getLocationID());
        saveLocationPreparedStatement.executeUpdate();
        saveLocationPreparedStatement.close();
    }

    public boolean saveShipLocation(DatabaseConnection databaseConnection, Object object) {
        ShipLocation shipLocation = (ShipLocation) object;
        boolean returnValue = false;

        try {
            saveShipLocationToDatabase(databaseConnection, shipLocation);
            returnValue = true;
        }catch (SQLException ex) {
            Logger.getLogger(LocationDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }


    private void saveShipLocationToDatabase(DatabaseConnection databaseConnection,
                                          ShipLocation shipLocation) throws SQLException {
        String sqlCommand =
                "INSERT INTO SHIP_LOCATION(MMSI,  LOCATION_ID )\n" +
                        "VALUES(?, ?)";

        executeShipLocationStatementOnDatabase(databaseConnection, shipLocation,
                sqlCommand);
    }


    private void executeShipLocationStatementOnDatabase(
            DatabaseConnection databaseConnection,
            ShipLocation shipLocation, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveLocationPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveLocationPreparedStatement.setInt(1, shipLocation.getmMSI());
        saveLocationPreparedStatement.setString(2, shipLocation.getLocationID());
        saveLocationPreparedStatement.executeUpdate();
        saveLocationPreparedStatement.close();
    }


    public List<Location> getPort (DatabaseConnection databaseConnection) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        List<Location> ports = new ArrayList<>();
        try {
            callStmt = connection.prepareCall("{ ?= call getPort }");
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                String locationID = rSet.getString(1);
                String name = rSet.getString(2);
                int positionID = rSet.getInt(3);
                String country = rSet.getString(4);
                String type = rSet.getString(5);
                int tripID = rSet.getInt(6);
                int capacity = rSet.getInt(7);
                ports.add(new Location(locationID.trim(), type.trim(), name.trim(), positionID, country.trim(), tripID, capacity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            callStmt.close();
        }
        return ports;
    }

    //US310
    public String getOccupation(DatabaseConnection databaseConnection,
                                        int locationID, int month) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        try {
            callStmt = connection.prepareCall("{ ?= call portOccupation(?,?) }");
            callStmt.registerOutParameter(1, Types.VARCHAR);
            callStmt.setInt(2, locationID);
            callStmt.setInt(3, month);
            callStmt.executeQuery();
            return callStmt.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            callStmt.close();
        }  throw new IllegalArgumentException();

    }

    //US305
    public String routeOfContainer(DatabaseConnection databaseConnection,
                                        int containerID, int clientID) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        try {
            callStmt = connection.prepareCall("{ ?= call routeOfContainer(?,?) }");
            callStmt.registerOutParameter(1, Types.VARCHAR);
            callStmt.setInt(2, containerID);
            callStmt.setInt(3, clientID);
            callStmt.execute();
            return callStmt.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            callStmt.close();
        }  throw new IllegalArgumentException();

    }

    //US306
        /*public String getOccupancyRate(DatabaseConnection databaseConnection,
                                        int staffID) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        try {
            callStmt = connection.prepareCall("{ ?= call getOccupancyRate(?) }");
            callStmt.registerOutParameter(1, Types.VARCHAR);
            callStmt.setInt(2, staffID);
            callStmt.execute();
            return callStmt.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            callStmt.close();
        }  throw new IllegalArgumentException();

    }*/

    //US407
    public String generateMaps(DatabaseConnection databaseConnection,
                                   int staffID) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        try {
            callStmt = connection.prepareCall("{ ?= call generateMaps1(?) }");
            callStmt.registerOutParameter(1, Types.VARCHAR);
            callStmt.setInt(2, staffID);
            callStmt.execute();
            return callStmt.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            callStmt.close();
        }  throw new IllegalArgumentException();

    }
}


