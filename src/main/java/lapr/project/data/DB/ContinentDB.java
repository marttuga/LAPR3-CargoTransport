package lapr.project.data.DB;
import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.Location.Continent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContinentDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Continent continent = (Continent) object;
        boolean returnValue = false;

        try {
            saveContinentToDatabase(databaseConnection, continent);
            returnValue = true;
        }catch (SQLException ex) {
            Logger.getLogger(ContinentDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    private void saveContinentToDatabase(DatabaseConnection databaseConnection,
                                         Continent continent) throws SQLException {
        insertContinentOnDatabase(databaseConnection, continent);

    }

    private void insertContinentOnDatabase(DatabaseConnection databaseConnection,
                                           Continent continent) throws SQLException {
        
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "INSERT INTO CONTINENT(CONTINENT)\n" +
                        "VALUES(?)";

        executeContinentStatementOnDatabase(databaseConnection, continent,
                sqlCommand);
    }

    private void executeContinentStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Continent continent, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveContinentPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveContinentPreparedStatement.setString( 1, continent.getContinent());
        saveContinentPreparedStatement.executeUpdate();
        saveContinentPreparedStatement.close();
    }


    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }
}
