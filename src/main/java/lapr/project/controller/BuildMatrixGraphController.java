package lapr.project.controller;

import lapr.project.data.ConnectionFactory;
import lapr.project.data.DB.*;
import lapr.project.data.DatabaseConnection;
import lapr.project.graph.matrix.MatrixGraph;
import lapr.project.model.Location.*;
import lapr.project.services.GraphMatrixCreate;
import lapr.project.utils.GraphSystem;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BuildMatrixGraphController {
    private static BuildMatrixGraphController instance = null;
    private final LocationDB portsDb;
    private final PositionDB positionDB;
    private final CountryDB countriesDb;
    private List<Location> ports;//Ports
    private List<Position> positionPorts;//Ports Position
    private List<Country> countries;//Countries List
    private final List<Location> capitals;
    private final List<Position> positionsCapitals;
    private final GraphMatrixCreate graphMatrixCreate;
    private List<Borders> countriesBorders;
    private final SeaDistsDB seaDistsDB;
    private List<SeaDists> seaDists;
    private final BordersDB bordersDB;


    private BuildMatrixGraphController() {
        portsDb = new LocationDB();
        countriesDb = new CountryDB();
        countries = new LinkedList<>();
        ports = new LinkedList<>();
        capitals = new LinkedList<>();
        positionPorts = new LinkedList<>();
        positionsCapitals = new LinkedList<>();
        positionDB = new PositionDB();
        graphMatrixCreate = new GraphMatrixCreate();
        countriesBorders = new LinkedList<>();
        seaDists = new LinkedList<>();
        seaDistsDB = new SeaDistsDB();
        bordersDB = new BordersDB();
    }

    public void loadGraph() throws SQLException, IOException {
        loadDataFromDb();//Carregar informação da DB
        addCapital();
        addCapitalConnections();
        addPorts();
        addPortsConnections();
        addConnectionBetweenCapitalAndPort();
        addConnectionBetweenNClosestPorts(3);
        File file = new File("graph//GraphOutPut.txt");
        if (file.exists()) {
            file.delete();
        }
        GraphSystem.outPutResume(BuildMatrixGraphController.getInstance().getLocationMap().toString());
    }

    public void addCapital() {
        for (Location l : capitals) {
            graphMatrixCreate.addCapitalVertex(l);
        }
    }

    public void addCapitalConnections() {
        graphMatrixCreate.addCapitalConnections(capitals, countriesBorders, positionsCapitals);

    }

    public void addPorts() {
        for (Location l : ports) {
            graphMatrixCreate.addPortVertex(l);
        }
    }

    public void addPortsConnections() {
        graphMatrixCreate.addPortConnections(seaDists, ports);
    }

    public void addConnectionBetweenCapitalAndPort() {
        graphMatrixCreate.addConnectionBetweenCapitalAndPort(capitals, ports, positionsCapitals, positionPorts);

    }

    public void addConnectionBetweenNClosestPorts(int n) {
        graphMatrixCreate.addConnectionBetweenNClosestPorts(3, ports, positionPorts);
    }

    public void loadDataFromDb() throws IOException, SQLException {
        DatabaseConnection databaseConnection = ConnectionFactory.getInstance().getDatabaseConnection();
        countriesBorders = bordersDB.getBorders(databaseConnection);//borders load
        countries = countriesDb.getCountry(databaseConnection);//countries load
        ports = portsDb.getPort(databaseConnection);//ports load
        positionPorts = positionDB.getPosition(databaseConnection);//ports positions
        seaDists = seaDistsDB.getSeadists(databaseConnection);//get seaDists

        int positionId = 1;
        for (Country c : countries) {
            capitals.add(new Location(c.getAlpha2code(), "capital", c.getCapital(), positionId, c.getCountry(), 0, 1));
            positionsCapitals.add(new Position(positionId, c.getLat(), c.getLon()));//capitals positions
            positionId++;
        }

    }

    public MatrixGraph<Location, Borders> getLocationMap() {
        return graphMatrixCreate.getLocationMap();
    }

    public List<Location> getPorts() {
        return ports;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public List<Location> getCapitals() {
        return capitals;
    }

    public List<Position> getPositionsCapitals() {
        return positionsCapitals;
    }

    public List<Borders> getCountriesBorders() {
        return countriesBorders;
    }

    public List<Position> getPositionPorts() {
        return positionPorts;
    }

    public List<SeaDists> getSeaDists() {
        return seaDists;
    }

    public void resetMatrix() {
        graphMatrixCreate.resetMatrix();
    }

    public static BuildMatrixGraphController getInstance() {
        if (instance == null) {
            instance = new BuildMatrixGraphController();
        }
        return instance;
    }
}
