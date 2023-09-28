package lapr.project.data.DB;


import lapr.project.data.ConnectionFactory;

import java.sql.*;
import java.time.LocalDateTime;

import java.util.LinkedList;
import java.util.List;

public class AvailableShipsDB {

    public List<String> AvailableShipsDB(ConnectionFactory connectionFactory) throws SQLException {
        try(Connection conect = connectionFactory.getDatabaseConnection().getConnection();
            CallableStatement calstat = conect.prepareCall("{ ? = call func_ships_available(?) }");){
            calstat.registerOutParameter(1, Types.REF_CURSOR);
            Timestamp now = Timestamp.valueOf(LocalDateTime.now()); //data do momento
            calstat.setTimestamp(2, now);
            calstat.execute();
            ResultSet result = (ResultSet) calstat.getObject(1);
            return returnShips(result);
        }

    }

    public List<String> returnShips(ResultSet result) throws SQLException {
        List<String> ships= new LinkedList<>();
        while(result.next()) {
            String returnS = new String("Ship MMSI: " + result.getInt(1) + "|" +
                    "Latitude: " + result.getDouble(2)) + "|" +
                    "Longitude: " + result.getDouble(3);

            ships.add(returnS);
        }

        return  ships;
    }
}