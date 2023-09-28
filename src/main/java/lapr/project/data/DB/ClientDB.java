package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.users.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Client client = (Client) object;
        boolean returnValue = false;

        try {
            saveClientToDatabase(databaseConnection, client);
            returnValue = true;
        }catch (SQLException ex) {
            Logger.getLogger(ClientDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }


    private void saveClientToDatabase(DatabaseConnection databaseConnection,
                                       Client client) throws SQLException {
        insertClientOnDatabase(databaseConnection, client);


    }


    private void insertClientOnDatabase(DatabaseConnection databaseConnection,
                                           Client client) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "INSERT INTO CLIENT(CLIENT_ID, NAME)\n" +
                        "VALUES(?,?)";

        executeClientStatementOnDatabase(databaseConnection, client,
                sqlCommand);
    }

    private void executeClientStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Client client, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveClientPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveClientPreparedStatement.setInt( 1, client.getClient_ID());
        saveClientPreparedStatement.setString( 2, client.getName());
        saveClientPreparedStatement.executeUpdate();
    }


    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }
}
