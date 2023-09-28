package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        User user = (User) object;
        boolean returnValue ;

        try {
            saveUserToDatabase(databaseConnection, user);

            //Save changes.
            returnValue = true;

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    private void saveUserToDatabase(DatabaseConnection databaseConnection,
                                    User user) throws SQLException {
       /* if (isUserOnDatabase(databaseConnection, user)) {
            updateUserOnDatabase(databaseConnection, user);
        } else {

        }*/
        insertUserOnDatabase(databaseConnection, user);
    }

    private boolean isUserOnDatabase(DatabaseConnection databaseConnection,
                                     User user) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        boolean isUserOnDatabase;

        String sqlCommand = "select * from user where username = ?";

        PreparedStatement getShipsPreparedStatement =
                connection.prepareStatement(sqlCommand);

        getShipsPreparedStatement.setString(1, user.getUsername());

        try (ResultSet userResultSet = getShipsPreparedStatement.executeQuery()) {

            if (userResultSet.next()) {
                // if client already exists in the database
                isUserOnDatabase = true;
            } else {

                // if client does not exist in the database
                isUserOnDatabase = false;
            }
        }

        return isUserOnDatabase;
    }


    private void insertUserOnDatabase(DatabaseConnection databaseConnection,
                                      User user) throws SQLException {
        String sqlCommand =
                "INSERT INTO USERR (USERNAME, PASSWORD, ROLE_TYPE, STAFF_ID)\n" +
                        "VALUES (?, ?, ?, ?)";

        executeUserStatementOnDatabase(databaseConnection, user,
                sqlCommand);

    }


    private void updateUserOnDatabase(DatabaseConnection databaseConnection,
                                      User user) throws SQLException {
        String sqlCommand =
                "UPDATE USER SET PASSWORD = ? WHERE USERNAME = ?";

        executeUserUpdateOnDatabase(databaseConnection, user,
                sqlCommand);
    }


    private void executeUserStatementOnDatabase(
            DatabaseConnection databaseConnection,
            User user, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveUserPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveUserPreparedStatement.setString(1, user.getUsername());
        saveUserPreparedStatement.setString(2, user.getPassword());
        saveUserPreparedStatement.setString(3, user.getRole());
        saveUserPreparedStatement.setInt(4, user.getStaffID());

        saveUserPreparedStatement.executeUpdate();
        saveUserPreparedStatement.close();

    }

    private void executeUserUpdateOnDatabase(
            DatabaseConnection databaseConnection,
            User user, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveUserPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveUserPreparedStatement.setString(1, user.getPassword());
        saveUserPreparedStatement.setString(2, user.getUsername());
        saveUserPreparedStatement.executeUpdate();
        saveUserPreparedStatement.close();
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }
}
