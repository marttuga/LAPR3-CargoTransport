package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.Location.Country;
import lapr.project.model.Location.Position;
import lapr.project.model.trip.Stops;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PositionDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Position position = (Position) object;
        boolean returnValue ;

        try {
            savePositionToDatabase(databaseConnection, position);

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


    private void savePositionToDatabase(DatabaseConnection databaseConnection,
                                     Position position) throws SQLException {
        String sqlCommand =
                "INSERT INTO POSITION (POSITION_ID, LATITUDE, LONGITUDE)\n" +
                        "VALUES (?, ?, ?)";

        executePositionStatementOnDatabase(databaseConnection, position,
                sqlCommand);

    }


    private void executePositionStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Position position, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement savePositionPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        savePositionPreparedStatement.setInt(1, position.getPositionID());
        savePositionPreparedStatement.setDouble(2, position.getLatitude());
        savePositionPreparedStatement.setDouble(3, position.getLongitude());
        savePositionPreparedStatement.executeUpdate();
        savePositionPreparedStatement.close();

    }


    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }


    public List<Position> getPosition (DatabaseConnection databaseConnection) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        List<Position> positions = new ArrayList<>();
        try {
            callStmt = connection.prepareCall("{ ?= call getPositions }");
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                int positionID = rSet.getInt(1);
                double lat = rSet.getDouble(2);
                double lon = rSet.getDouble(3);
                positions.add(new Position(positionID, lat, lon));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            callStmt.close();
        }
        return positions;
    }
}
