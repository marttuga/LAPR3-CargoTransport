
package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.Location.Country;
import lapr.project.model.container.Container;
import lapr.project.model.intermediateClasses.ClientContainer;
import lapr.project.model.intermediateClasses.ContainerCargoManifest;
import lapr.project.model.intermediateClasses.ShipContainer;
import lapr.project.model.ship.Ship;
import lapr.project.model.users.Client;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContainerDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Container container = (Container) object;
        boolean returnValue = false;

        try {
            insertContainerOnDatabase(databaseConnection, container);
            returnValue = true;
        } catch (SQLException ex) {
            Logger.getLogger(ContainerDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    public boolean saveShipContainer(DatabaseConnection databaseConnection, Object object) {
        ShipContainer shipContainer = (ShipContainer) object;
        boolean returnValue = false;

        try {
            insertShipContainerOnDatabase(databaseConnection ,shipContainer);
            returnValue = true;
        } catch (SQLException ex) {
            Logger.getLogger(ContainerDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    private void insertShipContainerOnDatabase(DatabaseConnection databaseConnection,
                                      ShipContainer shipContainer) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "INSERT INTO SHIP_CONTAINER(CONTAINER_ID, MMSI)\n" +
                        "VALUES(?, ?)";

        executeShipContainerStatementOnDatabase(databaseConnection, shipContainer,
                sqlCommand);
    }

    private void executeShipContainerStatementOnDatabase(
            DatabaseConnection databaseConnection,
            ShipContainer shipContainer, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveShipContainerPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveShipContainerPreparedStatement.setInt(1, shipContainer.getContainerID());
        saveShipContainerPreparedStatement.setInt(2, shipContainer.getmMSI());
        saveShipContainerPreparedStatement.executeUpdate();
        saveShipContainerPreparedStatement.close();
    }


    public boolean saveContainerCargoManifest(DatabaseConnection databaseConnection, Object object) {
        ContainerCargoManifest containerCargoManifest = (ContainerCargoManifest) object;
        boolean returnValue = false;

        try {
            insertContainerCargoManifestOnDatabase(databaseConnection ,containerCargoManifest);
            returnValue = true;
        } catch (SQLException ex) {
            Logger.getLogger(ContainerDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    private void insertContainerCargoManifestOnDatabase(DatabaseConnection databaseConnection,
                                               ContainerCargoManifest containerCargoManifest) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "INSERT INTO CONTAINER_CARGO_MANIFEST(CONTAINER_ID, CARGO_MANIFEST_ID, X, Y, Z, UNLOADING_LOCATION)\n" +
                        "VALUES(?, ?, ?, ?, ?, ?)";

        executeContainerCargoManifestStatementOnDatabase(databaseConnection, containerCargoManifest,
                sqlCommand);
    }

    private void executeContainerCargoManifestStatementOnDatabase(
            DatabaseConnection databaseConnection,
            ContainerCargoManifest containerCargoManifest, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveContainerCargoManifestPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveContainerCargoManifestPreparedStatement.setInt(1, containerCargoManifest.getCargoManifestID());
        saveContainerCargoManifestPreparedStatement.setInt(2, containerCargoManifest.getContainerID());
        saveContainerCargoManifestPreparedStatement.setInt(3, containerCargoManifest.getX());
        saveContainerCargoManifestPreparedStatement.setInt(4, containerCargoManifest.getY());
        saveContainerCargoManifestPreparedStatement.setInt(5, containerCargoManifest.getZ());
        saveContainerCargoManifestPreparedStatement.setString(6, containerCargoManifest.getUnloadingLocation());
        saveContainerCargoManifestPreparedStatement.executeUpdate();
        saveContainerCargoManifestPreparedStatement.close();
    }



    public boolean saveContainerClient(DatabaseConnection databaseConnection, Object object) {
        ClientContainer clientContainer = (ClientContainer) object;
        boolean returnValue = false;

        try {
            insertClientContainerOnDatabase(databaseConnection, clientContainer);
            returnValue = true;
        } catch (SQLException ex) {
            Logger.getLogger(ContainerDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }



    private void insertClientContainerOnDatabase(DatabaseConnection databaseConnection, ClientContainer clientContainer) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "INSERT INTO CLIENT_CONTAINER(CLIENT_ID, CONTAINER_ID,CARGO_MANIFEST_ID)\n" +
                        "VALUES( ?, ?,?)";

        executeClientContainerStatementOnDatabase(databaseConnection, clientContainer,
                sqlCommand);
    }

    private void executeClientContainerStatementOnDatabase(
            DatabaseConnection databaseConnection, ClientContainer clientContainer, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveContainerPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveContainerPreparedStatement.setInt(1, clientContainer.getClient_ID());
        saveContainerPreparedStatement.setInt(2, clientContainer.getContainerID());
        saveContainerPreparedStatement.setInt(3, clientContainer.getCargoManifestID());
        saveContainerPreparedStatement.executeUpdate();
    }

    private void insertContainerOnDatabase(DatabaseConnection databaseConnection,
                                           Container container) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "INSERT INTO CONTAINER(CONTAINER_ID, PAYLOAD, TARE, GROSS, TYPE, ISO_CODE)\n" +
                        "VALUES(?, ?, ?, ?, ?, ?)";

        executeContainerStatementOnDatabase(databaseConnection, container,
                sqlCommand);
    }

    private void executeContainerStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Container container, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveContainerPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveContainerPreparedStatement.setInt(1, container.getContainerID());
        saveContainerPreparedStatement.setDouble(2, container.getPayload());
        saveContainerPreparedStatement.setDouble(3, container.getTare());
        saveContainerPreparedStatement.setDouble(4, container.getGross());
        saveContainerPreparedStatement.setString(5, container.getType());
        saveContainerPreparedStatement.setString(6, container.getISOCode());
        saveContainerPreparedStatement.executeUpdate();
    }
/*
    public Container getContainersOffloaded(DatabaseConnection databaseConnection) throws SQLException{
        Connection connection = databaseConnection.getConnection();

        ResultSet rSet = null;
        try (CallableStatement callStmt = connection.prepareCall("{ ? = call fncgetcontainersoffloaded(?) }")) {

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            callStmt.execute();

            rSet = (ResultSet) callStmt.getObject(1);

            rSet.close();
            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Methods.closeResultSet(rSet);
            closeAll();
        }
        return null;
    }*/

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }


    /*


    public boolean getContainerOffloaded(DatabaseConnection databaseConnection,
                                        Container container){
        String sqlCommand = "{ call PROCADDPHARMACY(?,?) }";

        executeCallContainer(databaseConnection, container,
                sqlCommand);

    }

    private void executeCallContainer(
            DatabaseConnection databaseConnection,
            Container container, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        CallableStatement containerOffloaded =
                connection.prepareCall(
                        sqlCommand);
        containerOffloaded.setInt(1,  container.getClientID());
        containerOffloaded.setString(2,);
        containerOffloaded.execute();
        containerOffloaded.close();
    }

    */



    public boolean save(DatabaseConnection databaseConnection, int containerID) {
        boolean returnValue = false;

        try {
            getContainerSituation(databaseConnection, containerID);
            returnValue = true;
        } catch (SQLException ex) {
            Logger.getLogger(ContainerDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    //us204
    public String getContainerSituation(DatabaseConnection databaseConnection,
                                      int containerID) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        try {
            callStmt = connection.prepareCall("{ ?= call fnc_get_Container(?) }");
            callStmt.registerOutParameter(1, Types.VARCHAR);
            callStmt.setInt(2, containerID);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            while (rSet.next()) {
                String result = rSet.toString();
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            callStmt.close();
        }  throw new IllegalArgumentException();

    }

    //us312
    public String getContainerSituationWarnings(DatabaseConnection databaseConnection,
                                        int containerID) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        try {
            callStmt = connection.prepareCall("{ ?= call fnc_get_Container_Warning(?) }");
            callStmt.registerOutParameter(1, Types.VARCHAR);
            callStmt.setInt(2, containerID);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            while (rSet.next()) {
                String result = rSet.toString();
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            callStmt.close();
        }  throw new IllegalArgumentException();

    }


}

