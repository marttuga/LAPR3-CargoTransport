package lapr.project.ui;

import lapr.project.controller.BuildMatrixGraphController;
import lapr.project.controller.ReadFilesController;
import lapr.project.data.ConnectionFactory;

import lapr.project.data.DB.*;
import lapr.project.data.DataReader;
import lapr.project.data.DatabaseConnection;
import lapr.project.graph.Graph;
import lapr.project.model.Location.Borders;
import lapr.project.model.Location.Location;
import lapr.project.services.ColorMap;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = Logger.getLogger("MainLog");

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * Application main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
      /*  CalculatorExample calculatorExample = new CalculatorExample();
        int value = calculatorExample.sum(3, 5);

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.valueOf(value));
        }*/


        Logger.getLogger("group101")
                .log(Level.SEVERE, "teste");

        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = ConnectionFactory.getInstance()
                    .getDatabaseConnection();
        } catch (IOException exception) {
            Logger.getLogger("MainLog")
                    .log(Level.SEVERE, null, exception);
        }
        Connection connection = databaseConnection.getConnection();
        System.out.println("Connected to the database!");

        //Fazer load da base de dados, FAZER SEMPRE ANTES O CREATE TABLES



        ReadFilesController readFilesController = new ReadFilesController();
        DataReader dataReader = new DataReader();
        readFilesController.load();

        dataReader.loadIntoDatabase(connection, databaseConnection);

        /*MainMenuUI mainMenuUI = new MainMenuUI();
        mainMenuUI.run();*/



     /*   Graph<Location, Borders> graph = BuildMatrixGraphController.getInstance().getLocationMap();
        ColorMap colorMap  = new ColorMap();
        System.out.println(colorMap.colorVertices(graph));*/

 /*  ContainerDB containerDB= new ContainerDB();
       //System.out.println(containerDB.getContainerSituation(databaseConnection,200031));
        System.out.println(containerDB.getContainerSituationWarnings(databaseConnection,450032)); //450033
*/
      /*  CargoManifestDB cargoManifestDB = new CargoManifestDB();
        System.out.println("sum of the cargo manifests during this year: "+ cargoManifestDB.getCargoPerYear(2020,databaseConnection));

       System.out.println("average of the containers per cargo manifest during this year: "+ cargoManifestDB.getAvgContainersPerManifest(databaseConnection,2020));

        AvailableShipsDB availableShipsDB = new AvailableShipsDB();
        System.out.println("Ships will be available on Monday next week and their location: "+ availableShipsDB.AvailableShipsDB(ConnectionFactory.getInstance()));
*/
        // Gets para o pedro, dps vão ter q ir para um controller

        //CountryDB countryDB = new CountryDB();
        //System.out.println(countryDB.getCountry(databaseConnection));
        //LocationDB locationDB = new LocationDB();
        //System.out.println(locationDB.getPort(databaseConnection));
        //PositionDB positionDB = new PositionDB();
        //System.out.println(positionDB.getPosition(databaseConnection));

    /*    BordersDB bordersDB = new BordersDB();
        System.out.println(bordersDB.getBorders(databaseConnection));

        AuditTrailDB auditTrailDB= new AuditTrailDB();
        System.out.println("List of all operations performed on a given container of a given manifest," +
                " in chronological order" + auditTrailDB.getAuditTrail(databaseConnection, 200031 ,23423));

*/
        /*BordersDB bordersDB = new BordersDB();
        System.out.println(bordersDB.getBorders(databaseConnection));*/
        //US305 -- US306
        /*LocationDB locationDB = new LocationDB();
        //System.out.println(locationDB.routeOfContainer(databaseConnection,447762, 200031)); //447762, 200031
        //System.out.println(locationDB.getOccupancyRate(databaseConnection,463143)); //463143
        System.out.println(locationDB.generateMaps(databaseConnection, 9876));//9876 */

        //US310
        //LocationDB locationDB = new LocationDB();
        //System.out.println(locationDB.getOccupation(databaseConnection,834526,1));

    }
}