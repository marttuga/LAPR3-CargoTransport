package lapr.project.controller;
/*
import lapr.project.data.DB.AuditTrailDB;
import lapr.project.data.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuditTrailController {

    public boolean save(DatabaseConnection databaseConnection, int containerID, int cargoManifestID) {
        boolean returnValue = false;

        try {
            getAuditTrail(databaseConnection, containerID, cargoManifestID);
            returnValue = true;
        } catch (SQLException ex) {
            Logger.getLogger(AuditTrailDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    public void getAuditTrail(DatabaseConnection databaseConnection,
                                         int containerID, int cargoManifestID) throws SQLException {
        String sqlCommand = "{ call getAuditTrail(?) }";
        executeCallAuditTrail(databaseConnection, containerID,cargoManifestID,
                sqlCommand);
    }

    private void executeCallAuditTrail(
            DatabaseConnection databaseConnection,
            int containerID,int cargoManifestID, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        CallableStatement auditTrail =
                connection.prepareCall(
                        sqlCommand, containerID, cargoManifestID);
        auditTrail.setInt(1, containerID);
        auditTrail.execute();
        String res = auditTrail.getNString(containerID);
        System.out.print(res);
        auditTrail.close();
    }
    public String getAudit(int containerID, int cargoManifestID, DatabaseConnection connectionFactory) throws SQLException {
        return new AuditTrailDB().getAuditTrail(connectionFactory, containerID,cargoManifestID);
   }
}*/
