package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Continent;
import lapr.project.model.Location.Country;
import lapr.project.model.Location.SeaDists;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeaDistsDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        SeaDists seaDists = (SeaDists) object;
        boolean returnValue = false;

        try {
            saveSeaDistsToDatabase(databaseConnection, seaDists);
            returnValue = true;
        }catch (SQLException ex) {
            Logger.getLogger(ContinentDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }


    private void saveSeaDistsToDatabase(DatabaseConnection databaseConnection,
                                       SeaDists seaDists) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "INSERT INTO SEADISTS(COUNTRYORIGIN, PORTIDORIGIN, PORTORIGIN, COUNTRYDESTINY, PORTIDDESTINY, PORTDESTINY, SEADISTS)\n" +
                        "VALUES(?,?,?,?,?,?,?)";

        executeSeaDistsStatementOnDatabase(databaseConnection, seaDists,
                sqlCommand);
    }

    private void executeSeaDistsStatementOnDatabase(
            DatabaseConnection databaseConnection,
            SeaDists seaDists, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveSeaDistsPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveSeaDistsPreparedStatement.setString( 1, seaDists.getCountryOrigin());
        saveSeaDistsPreparedStatement.setInt(2, seaDists.getPortIDOrigin());
        saveSeaDistsPreparedStatement.setString(3, seaDists.getPortOrigin());
        saveSeaDistsPreparedStatement.setString(4, seaDists.getCountryDestiny());
        saveSeaDistsPreparedStatement.setInt(5, seaDists.getPortIDDestiny());
        saveSeaDistsPreparedStatement.setString(6, seaDists.getCountryOrigin());
        saveSeaDistsPreparedStatement.setInt(7, seaDists.getSeaDists());
        saveSeaDistsPreparedStatement.executeUpdate();
        saveSeaDistsPreparedStatement.close();
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }


    public List<SeaDists> getSeadists (DatabaseConnection databaseConnection) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        List<SeaDists> seaDists = new ArrayList<>();
        try {
            callStmt = connection.prepareCall("{ ?= call getSeaDists }");
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            while (rSet.next()) {
                String CountryOrigin = rSet.getString(1);
                int portIDOrigin = rSet.getInt(2);
                String portOrigin = rSet.getString(3);
                String CountryDestiny = rSet.getString(4);
                int portIDDestiny = rSet.getInt(5);
                String portDestiny = rSet.getString(6);
                int seaDist = rSet.getInt(7);
                seaDists.add(new SeaDists(CountryOrigin.trim(), portIDOrigin, portOrigin.trim(), CountryDestiny.trim(), portIDDestiny, portDestiny.trim(), seaDist));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            callStmt.close();
        }
        return seaDists;
    }
}
