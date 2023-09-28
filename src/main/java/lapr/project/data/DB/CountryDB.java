package lapr.project.data.DB;

import lapr.project.data.DatabaseConnection;
import lapr.project.data.Persistable;
import lapr.project.model.Location.Country;
import lapr.project.model.Location.Location;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountryDB implements Persistable {
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        Country country = (Country) object;
        boolean returnValue = false;

        try {
            saveCountryToDatabase(databaseConnection, country);
            returnValue = true;
        }catch (SQLException ex) {
            Logger.getLogger(ContainerDB.class.getName())
                    .log(Level.SEVERE, null, ex);
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }


    private void saveCountryToDatabase(DatabaseConnection databaseConnection,
                                         Country country) throws SQLException {
        insertCountryOnDatabase(databaseConnection, country);
    }


    private void insertCountryOnDatabase(DatabaseConnection databaseConnection,
                                           Country country) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String sqlCommand =
                "INSERT INTO COUNTRY(CONTINENT, ALPHA2CODE, ALPHA3CODE ,COUNTRY, POPULATION, CAPITAL, LAT, LON)\n" +
                        "VALUES(?,?,?,?,?,?,?,?)";

        executeCountryrStatementOnDatabase(databaseConnection, country,
                sqlCommand);
    }

    private void executeCountryrStatementOnDatabase(
            DatabaseConnection databaseConnection,
            Country country, String sqlCommand) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveCountryPreparedStatement =
                connection.prepareStatement(
                        sqlCommand);
        saveCountryPreparedStatement.setString( 1, country.getContinent());
        saveCountryPreparedStatement.setString(2, country.getAlpha2code());
        saveCountryPreparedStatement.setString(3, country.getAlpha3code());
        saveCountryPreparedStatement.setString( 4, country.getCountry());
        saveCountryPreparedStatement.setDouble(5,country.getPopulation());
        saveCountryPreparedStatement.setString(6, country.getCapital());
        saveCountryPreparedStatement.setDouble(7, country.getLat());
        saveCountryPreparedStatement.setDouble(8, country.getLon());
        saveCountryPreparedStatement.executeUpdate();
        saveCountryPreparedStatement.close();
    }

    public List<Country> getCountry (DatabaseConnection databaseConnection) throws SQLException {
        CallableStatement callStmt = null;
        Connection connection = databaseConnection.getConnection();
        List<Country> countries = new ArrayList<>();
        try {
            callStmt = connection.prepareCall("{ ?= call getCountry }");
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                String continent = rSet.getString(1);
                String alpha2code = rSet.getString(2);
                String alpha3code = rSet.getString(3);
                String country = rSet.getString(4);
                Double population = rSet.getDouble(5);
                String capital = rSet.getString(6);
                Double lat = rSet.getDouble(7);
                Double lon = rSet.getDouble(8);
                countries.add(new Country(continent.trim(), alpha2code.trim(), alpha3code.trim(), country.trim(), population, capital.trim(), lat, lon));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            callStmt.close();
        }
        return countries;
    }





    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }
}
