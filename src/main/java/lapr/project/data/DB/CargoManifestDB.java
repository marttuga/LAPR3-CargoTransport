package lapr.project.data.DB;

import lapr.project.data.ConnectionFactory;
import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.cargoManifest.CargoManifest;
import lapr.project.model.container.Container;
import oracle.jdbc.OracleTypes;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargoManifestDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        CargoManifest cargoManifest = (CargoManifest) object;
        boolean returnValue = false;

        try {
            saveCargoManifestToDatabase(databaseConnection, cargoManifest);
            returnValue = true;
        }catch (SQLException ex) {
            Logger.getLogger(CargoManifestDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }


    private void saveCargoManifestToDatabase(DatabaseConnection databaseConnection,
                                         CargoManifest cargoManifest) throws SQLException {
      /*  if (isCargoManifestOnDatabase(databaseConnection, cargoManifest)) {
            updateCargoManifestOnDatabase(databaseConnection, cargoManifest);
        } else {
            insertCargoManifestOnDatabase(databaseConnection, cargoManifest);
        }*/

        insertCargoManifestOnDatabase(databaseConnection, cargoManifest);

    }


    private boolean isCargoManifestOnDatabase(DatabaseConnection databaseConnection,
                                          CargoManifest cargoManifest) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        boolean isCargoManifestOnDatabase = false;

        String sqlCommand = "select * from cargo_manifest where cargo_manifest_id = ?";

        PreparedStatement getContainersPreparedStatement =
                connection.prepareStatement(sqlCommand);

        getContainersPreparedStatement.setInt(1, cargoManifest.getCargoManifestID());

        try (ResultSet containersResultSet = getContainersPreparedStatement.executeQuery()) {

            if (containersResultSet.next()) {
                // if container already exists in the database
                isCargoManifestOnDatabase = true;
            } else {

                // if container does not exist in the database
                isCargoManifestOnDatabase = false;
            }
        }
        return isCargoManifestOnDatabase;
    }

    private void updateCargoManifestOnDatabase(DatabaseConnection databaseConnection,
                                           CargoManifest cargoManifest) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "UPDATE CONTAINER SET X = ?, Y = ?, Z = ?  WHERE CONTAINER_ID = ?";

        executeCargoManifestUpdateOnDatabase(databaseConnection, cargoManifest,
                sqlCommand);
    }

    private void executeCargoManifestUpdateOnDatabase(
            DatabaseConnection databaseConnection,
            CargoManifest cargoManifest, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveCargoManifestPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);

        saveCargoManifestPreparedStatement.executeUpdate();
    }

    private void insertCargoManifestOnDatabase(DatabaseConnection databaseConnection,
                                           CargoManifest cargoManifest) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "INSERT INTO CARGO_MANIFEST(CARGO_MANIFEST_ID, GROSS_WEIGHT,MANIFEST_DATE, TYPE, STOPS_NAME, VEHICLE_ID)\n" +
                        "VALUES(?, ?,?, ?, ?, ?)";

        executeCargoManifestStatementOnDatabase(databaseConnection, cargoManifest,
                sqlCommand);
    }

    private void executeCargoManifestStatementOnDatabase(
            DatabaseConnection databaseConnection,
            CargoManifest cargoManifest, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveCargoManifestOnDatabase =
                connection.prepareStatement(
                        sqlCommand);
        saveCargoManifestOnDatabase.setInt(1,cargoManifest.getCargoManifestID());
        saveCargoManifestOnDatabase.setInt(2,cargoManifest.getGrossWeight());
        saveCargoManifestOnDatabase.setString(3,cargoManifest.getManifestDate().toString());
        saveCargoManifestOnDatabase.setString(4,cargoManifest.getType());
        saveCargoManifestOnDatabase.setString(5,cargoManifest.getStopName());
        saveCargoManifestOnDatabase.setString(6,cargoManifest.getVehicleID());
        saveCargoManifestOnDatabase.executeUpdate();
        saveCargoManifestOnDatabase.close();
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }






    public double getAvgContainersPerManifest(DatabaseConnection databaseConnection, int year) {
        Connection connection = databaseConnection.getConnection();
        try (CallableStatement callStmt = connection.prepareCall("{ ?= call fnc_get_Containers_Avg(?) }")) {
            callStmt.registerOutParameter(1, Types.DOUBLE);
            callStmt.setInt(2, year);
            callStmt.executeQuery();
            return callStmt.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }







    public int getCargoPerYear(int year, DatabaseConnection databaseConnection)throws SQLException{
        Connection connection = databaseConnection.getConnection();
        try (CallableStatement callStmt = connection.prepareCall("{ ?= call fnc_get_Cargo_Per_Year(?) }")) {
            callStmt.registerOutParameter(1, Types.INTEGER);
            callStmt.setInt(2, year);
            callStmt.executeQuery();
            return callStmt.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

}
