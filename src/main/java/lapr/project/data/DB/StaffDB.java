package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.intermediateClasses.StaffShip;
import lapr.project.model.users.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StaffDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Staff staff = (Staff) object;
        boolean returnValue ;

        try {
            saveStaffToDatabase(databaseConnection, staff);

            //Save changes.
            returnValue = true;

        } catch (SQLException ex) {
            Logger.getLogger(StaffDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    public boolean saveStaffShipIntoDatabase(DatabaseConnection databaseConnection, Object object) {
        StaffShip staffShip = (StaffShip) object;
        boolean returnValue ;

        try {
            saveStaffShipToDatabase(databaseConnection, staffShip);

            //Save changes.
            returnValue = true;

        } catch (SQLException ex) {
            Logger.getLogger(StaffDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    private void saveStaffToDatabase(DatabaseConnection databaseConnection,
                                     Staff staff) throws SQLException {
        String sqlCommand =
                "INSERT INTO STAFF(STAFF_ID, NAME, CARGO_MANIFEST_ID, LOCATION_ID, STOPS_NAME )\n" +
                        "VALUES(?, ?, ?, ?,?)";

        executeStaffStatementOnDatabase(databaseConnection, staff,
                sqlCommand);

    }


    private void executeStaffStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Staff staff, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveStaffPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveStaffPreparedStatement.setInt(1, staff.getStaffID());
        saveStaffPreparedStatement.setString(2, staff.getName());
        saveStaffPreparedStatement.setInt(3,staff.getCargoManifestID());
        saveStaffPreparedStatement.setString(4,  staff.getLocationID());
        saveStaffPreparedStatement.setString(5,  staff.getNameStop());
        saveStaffPreparedStatement.executeUpdate();
        saveStaffPreparedStatement.close();

    }


    private void saveStaffShipToDatabase(DatabaseConnection databaseConnection,
                                     StaffShip staffShip) throws SQLException {
        String sqlCommand =
                "INSERT INTO STAFF_SHIP( MMSI,STAFF_ID)\n" +
                        "VALUES(?, ?)";

        executeStaffShipStatementOnDatabase(databaseConnection, staffShip,
                sqlCommand);

    }


    private void executeStaffShipStatementOnDatabase(
            DatabaseConnection databaseConnection,
            StaffShip staffShip, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveStaffShipPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveStaffShipPreparedStatement.setInt(1, staffShip.getmMSI());
        saveStaffShipPreparedStatement.setInt(2, staffShip.getStaffID());

        saveStaffShipPreparedStatement.executeUpdate();
        saveStaffShipPreparedStatement.close();
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }
}
