package lapr.project.data.DB;


import lapr.project.data.ConnectionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AvailableShipsController {
    AvailableShipsDB availableShipsDB;

    private AvailableShipsController() {
        availableShipsDB = new AvailableShipsDB();
    }

    public List<String> AvailableShipsDB() throws IOException, SQLException {
        return availableShipsDB.AvailableShipsDB(ConnectionFactory.getInstance());
    }

    public AvailableShipsDB getAvailableShipsDB() {
        return availableShipsDB;
    }

    public void setAvailableShipsDB(AvailableShipsDB availableShipsDB) {
        this.availableShipsDB = availableShipsDB;
    }
}
