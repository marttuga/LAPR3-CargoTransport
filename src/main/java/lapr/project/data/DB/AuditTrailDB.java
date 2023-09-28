package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.audittrail.AuditTrail;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuditTrailDB implements Persistable {

    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        AuditTrail auditTrail = (AuditTrail) object;
        boolean returnValue = false;

        try {
            insertAuditTrailOnDatabase(databaseConnection, auditTrail);
            returnValue = true;
        } catch (SQLException ex) {
            Logger.getLogger(AuditTrailDB.class.getName())
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

    private void insertAuditTrailOnDatabase(DatabaseConnection databaseConnection,
                                           AuditTrail auditTrail) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "INSERT INTO AUDITTRAIL(CONTAINER_ID, CARGO_MANIFEST_ID, USERNAME, TYPE_OPERATION, DATE_TIME_OPERATION)\n" +
                        "VALUES(?, ?, ?, ?, ?, ?)";

        executeAuditTrailStatementOnDatabase(databaseConnection, auditTrail,
                sqlCommand);
    }

    private void executeAuditTrailStatementOnDatabase(
            DatabaseConnection databaseConnection,
            AuditTrail auditTrail, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveAuditTrailPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveAuditTrailPreparedStatement.setInt(1, auditTrail.getContainerID());
        saveAuditTrailPreparedStatement.setInt(2, auditTrail.getCargoManifestID());
        saveAuditTrailPreparedStatement.setString(3, auditTrail.getUsername());
        saveAuditTrailPreparedStatement.setString(4, auditTrail.getTypeOperation());
        saveAuditTrailPreparedStatement.setTimestamp(5, auditTrail.getDateTimeOperation());
        saveAuditTrailPreparedStatement.executeUpdate();
    }


    //us304
    public String getAuditTrail(DatabaseConnection databaseConnection,
                                        int containerID, int cargoManifestID) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        try {
            callStmt = connection.prepareCall("{ ?= call func_auditrail(?) }");
            callStmt.registerOutParameter(1, Types.VARCHAR);
            callStmt.setInt(2, containerID);
            callStmt.setInt(3, cargoManifestID);
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
