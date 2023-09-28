package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.trip.Stops;
import lapr.project.model.users.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoleDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Role role = (Role) object;
        boolean returnValue ;

        try {
            saveRoleToDatabase(databaseConnection, role);

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


    private void saveRoleToDatabase(DatabaseConnection databaseConnection,
                                     Role role) throws SQLException {
        String sqlCommand =
                "INSERT INTO ROLE(ROLE_TYPE )\n" +
                        "VALUES(?)";

        executeRoleStatementOnDatabase(databaseConnection, role,
                sqlCommand);

    }


    private void executeRoleStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Role role, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveRolePreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveRolePreparedStatement.setString(1, role.getRole());
        saveRolePreparedStatement.executeUpdate();
        saveRolePreparedStatement.close();

    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }
}
