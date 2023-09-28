package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Continent;
import lapr.project.model.Location.Position;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BordersDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Borders borders = (Borders) object;
        boolean returnValue = false;

        try {
            saveBordersToDatabase(databaseConnection, borders);
            returnValue = true;
        }catch (SQLException ex) {
            Logger.getLogger(ContinentDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }


    private void saveBordersToDatabase(DatabaseConnection databaseConnection,
                                           Borders borders) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "INSERT INTO BORDERS(COUNTRYORIGIN, COUNTRYDESTINY)\n" +
                        "VALUES(?,?)";

        executeBordersStatementOnDatabase(databaseConnection, borders,
                sqlCommand);
    }

    private void executeBordersStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Borders borders, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveBordersPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveBordersPreparedStatement.setString( 1, borders.getCountryOrigin());
        saveBordersPreparedStatement.setString(2, borders.getCountryDestiny());
        saveBordersPreparedStatement.executeUpdate();
        saveBordersPreparedStatement.close();
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }


    public List<Borders> getBorders (DatabaseConnection databaseConnection) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        List<Borders> borders = new ArrayList<>();
        try {
            callStmt = connection.prepareCall("{ ?= call getBorders }");
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                String countryOrigin = rSet.getString(1);
                String countryDestiny = rSet.getString(2);
                borders.add(new Borders(countryOrigin.trim(), countryDestiny.trim()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            callStmt.close();
        }
        return borders;
    }
}
