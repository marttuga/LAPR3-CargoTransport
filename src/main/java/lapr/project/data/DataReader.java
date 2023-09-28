package lapr.project.data;

import lapr.project.data.DB.*;
import lapr.project.model.Location.*;
import lapr.project.model.Truck.Truck;
import lapr.project.model.Vehicle.Vehicle;
import lapr.project.model.cargoManifest.CargoManifest;
import lapr.project.model.container.Container;
import lapr.project.model.intermediateClasses.*;
import lapr.project.model.ship.Ship;
import lapr.project.model.trip.Stops;
import lapr.project.model.trip.Trip;
import lapr.project.model.users.Client;
import lapr.project.model.users.Role;
import lapr.project.model.users.Staff;
import lapr.project.model.users.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.Date.*;

public class DataReader {
    private static final String FILE_SHIPS_SMALL = "CSVfiles//sships.csv";
    private static final String FILE_CONTAINERS_SMALL = "CSVfiles//container.csv";
    private static final String FILE_CARGO_MANIFEST_SMALL = "CSVfiles//cargoManifest.csv";
    private static final String FILE_CONTINENT_SMALL = "CSVfiles//continent.csv";
    private static final String FILE_COUNTRY_SMALL = "CSVfiles//countries.csv";
    private static final String FILE_CLIENT_SMALL = "CSVfiles//client.csv";
    private static final String FILE_CLIENT_CONTAINER_SMALL = "CSVfiles//client_container.csv";
    private static final String FILE_USER_SMALL = "CSVfiles//user.csv";
    private static final String FILE_STAFF_SMALL = "CSVfiles/staff.csv";
    private static final String FILE_STAFF_SHIP_SMALL = "CSVfiles/staff_ship.csv";
    private static final String FILE_LOCATION_SMALL = "CSVfiles//location.csv";
    private static final String FILE_STOPS_SMALL = "CSVfiles//stops.csv";
    private static final String FILE_ROLE_SMALL = "CSVfiles//role.csv";
    private static final String FILE_VEHICLE_SMALL = "CSVfiles//vehicle.csv";
    private static final String FILE_TRIP_SMALL = "CSVfiles//trip.csv";
    private static final String FILE_POSITION_SMALL = "CSVfiles//position.csv";
    private static final String FILE_TRUCK_SMALL = "CSVfiles//truck.csv";
    private static final String FILE_SHIP_LOCATION_SMALL = "CSVfiles//ship_location.csv";
    private static final String FILE_CONTAINER_CARGO_SMALL = "CSVfiles//container_cargoManifest.csv";
    private static final String FILE_SHIP_CONTAINER_SMALL = "CSVfiles//ship_container.csv";
    private static final String FILE_BORDERS_SMALL = "CSVfiles//borders.csv";
    private static final String FILE_SEA_DISTS_SMALL = "CSVfiles//seadists.csv";


    public void loadIntoDatabase(Connection connection, DatabaseConnection databaseConnection) {
        try {
            System.out.println("========================================" + "\n|------ Start Loading Files Into Database --------|");
            readContinentIntoDatabase(connection, databaseConnection);
            readCountryIntoDatabase(connection,databaseConnection);
            readPositionIntoDatabase(connection, databaseConnection);
            readVehiclesIntoDatabase(connection, databaseConnection);
            readShipsIntoDatabase(connection, databaseConnection);
            readTripIntoDatabase(connection, databaseConnection);
            readStopsIntoDatabase(connection, databaseConnection);
            readLocationIntoDatabase(connection, databaseConnection);
            readTruckIntoDatabase(connection, databaseConnection);
            readShipLocationIntoDatabase(connection, databaseConnection);
            readContainerIntoDatabase(connection, databaseConnection);
            readShipContainerIntoDatabase(connection, databaseConnection);
            readClientIntoDatabase(connection, databaseConnection);
            readCargoManifestIntoDatabase(connection, databaseConnection);
            readClientContainerIntoDatabase(connection, databaseConnection);

            readContainerCargoManifestIntoDatabase(connection, databaseConnection);
            readStaffIntoDatabase(connection, databaseConnection);
           readStaffShipIntoDatabase(connection, databaseConnection);
            readRoleIntoDatabase(connection, databaseConnection);
           readUserIntoDatabase(connection, databaseConnection);

            readBordersIntoDatabase(connection, databaseConnection);
            readSeaDistsIntoDatabase(connection, databaseConnection);

            System.out.println("|- End Loading Files Into Database With Success -|" + "\n========================================");

        } catch (Exception ex) {
            ex.printStackTrace();
            //System.out.println("File localization is invalid!");
        }
    }

    private void readVehiclesIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_VEHICLE_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVehicleID(aux[0]);
                    VehicleDB vehicleDB = new VehicleDB();
                    if (!vehicleDB.save(databaseConnection, vehicle)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added vehicle!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void readShipsIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException{
        String[] aux;
        Scanner sc = new Scanner(new FileReader( FILE_SHIPS_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Ship ship = new Ship();
                    ship.setmMSI(Integer.parseInt(aux[0]));
                    ship.setiMO(aux[8]);
                    ship.setCallSign(aux[9]);
                    ship.setVesselType(Integer.parseInt(aux[10]));
                    ship.setVesselName(aux[7]);
                    ship.setDraft(Double.parseDouble(aux[13]));
                    ship.setWidth(Integer.parseInt(aux[12]));
                    ship.setLength(Integer.parseInt(aux[11]));
                    ship.setVehicleID(aux[16]);
                    ShipDB shipDB = new ShipDB();

                    if (!shipDB.save(databaseConnection, ship)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added Ship!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void readContainerIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_CONTAINERS_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Container container = new Container();
                    container.setContainerID(Integer.parseInt(aux[0]));
                    container.setPayload(Double.parseDouble(aux[1]));
                    container.setTare(Double.parseDouble(aux[2]));
                    container.setGross(Double.parseDouble(aux[3]));
                    container.setType(aux[4]);
                    container.setISOCode(aux[5]);
                    ContainerDB containerDB = new ContainerDB();


                    if (!containerDB.save(databaseConnection, container)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added Container!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void readClientContainerIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_CLIENT_CONTAINER_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    ClientContainer clientContainer = new ClientContainer();
                    clientContainer.setClient_ID(Integer.parseInt(aux[0]));
                    clientContainer.setContainerID(Integer.parseInt(aux[1]));
                    clientContainer.setCargoManifestID(Integer.parseInt(aux[2]));
                    ContainerDB containerDB = new ContainerDB();
                    if (!containerDB.saveContainerClient(databaseConnection, clientContainer)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added Client Container!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readContainerCargoManifestIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_CONTAINER_CARGO_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    ContainerCargoManifest containerCargoManifest = new ContainerCargoManifest();
                    containerCargoManifest.setCargoManifestID(Integer.parseInt(aux[0]));
                    containerCargoManifest.setContainerID(Integer.parseInt(aux[1]));
                    containerCargoManifest.setX(Integer.parseInt(aux[2]));
                    containerCargoManifest.setY(Integer.parseInt(aux[3]));
                    containerCargoManifest.setZ(Integer.parseInt(aux[4]));
                    containerCargoManifest.setUnloadingLocation(aux[5]);
                    ContainerDB containerDB = new ContainerDB();


                    if (!containerDB.saveContainerCargoManifest(databaseConnection, containerCargoManifest)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added Container_CargoManifest!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void readShipLocationIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_SHIP_LOCATION_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    ShipLocation shipLocation = new ShipLocation();
                    shipLocation.setmMSI(Integer.parseInt(aux[0]));
                    shipLocation.setLocationID(aux[1]);
                    LocationDB locationDB = new LocationDB();
                    if (!locationDB.saveShipLocation(databaseConnection, shipLocation)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added Ship_Location!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readShipContainerIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException{
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_SHIP_CONTAINER_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    ShipContainer shipContainer = new ShipContainer();
                    shipContainer.setContainerID(Integer.parseInt(aux[0]));
                    shipContainer.setmMSI(Integer.parseInt(aux[1]));
                    ContainerDB containerDB = new ContainerDB();


                    if (!containerDB.saveShipContainer(databaseConnection, shipContainer)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added ship Container!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readCargoManifestIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException{
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_CARGO_MANIFEST_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    CargoManifest cargoManifest = new CargoManifest();
                    cargoManifest.setCargoManifestID(Integer.parseInt(aux[0]));
                    cargoManifest.setGrossWeight(Integer.parseInt(aux[1]));
                    cargoManifest.setManifestDate(Date.valueOf(aux[2]));
                    cargoManifest.setType(aux[3]);
                    cargoManifest.setStopName(aux[5]);
                    cargoManifest.setVehicleID(aux[4]);

                    CargoManifestDB cargoManifestDB = new CargoManifestDB();

                    if (!cargoManifestDB.save(databaseConnection, cargoManifest)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added Cargo Manifest!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readLocationIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException{
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_LOCATION_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Location location = new Location();
                    location.setLocationID(aux[0]);
                    location.setName(aux[1]);
                    location.setPositionID(Integer.parseInt(aux[2]));
                    location.setCountry(aux[3]);
                    location.setType(aux[4]);
                    location.setTripID(Integer.parseInt(aux[5]));
                    location.setCapacity(Integer.parseInt(aux[6]));
                    LocationDB locationDB = new LocationDB();
                    if (!locationDB.save(databaseConnection, location)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added location!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readTripIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException{
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_TRIP_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Trip trip = new Trip();
                    trip.setTripID(Integer.parseInt(aux[0]));
                    trip.setVehicleID(aux[1]);
                    trip.setShipMMSI(aux[2]);
                    trip.setDeparture(aux[3]);
                    trip.setArrival(aux[4]);
                    trip.setDepartureDate( valueOf(aux[5]));
                    trip.setArrivalDate(valueOf(aux[6]));

                    TripDB tripDB = new TripDB();
                    if (!tripDB.save(databaseConnection, trip)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added trip!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readStopsIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_STOPS_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Stops stops = new Stops();
                    stops.setName(aux[0]);
                    stops.setTripID(Integer.parseInt(aux[1]));
                    stops.setDepartureDateStops( valueOf(aux[2]));
                    stops.setArrivalDateStops(valueOf(aux[3]));
                    StopsDB stopsDB = new StopsDB();
                    if (!stopsDB.save(databaseConnection, stops)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added stops!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void readPositionIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException{
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_POSITION_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Position position = new Position();
                    position.setPositionID(Integer.parseInt(aux[0]));
                    position.setLatitude(Double.parseDouble(aux[1]));
                    position.setLongitude(Double.parseDouble(aux[2]));
                    PositionDB positionDB = new PositionDB();
                    if (!positionDB.save(databaseConnection, position)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added Position!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }




    private void readContinentIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_CONTINENT_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Continent continent = new Continent();
                    continent.setContinent(aux[0]);
                    ContinentDB continentDB = new ContinentDB();

                    if (!continentDB.save(databaseConnection, continent)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added Continent!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readBordersIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_BORDERS_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(",");
                    Borders borders = new Borders();
                    borders.setCountryOrigin(aux[0]);
                    borders.setCountryDestiny(aux[1]);
                    BordersDB bordersDB = new BordersDB();

                    if (!bordersDB.save(databaseConnection, borders)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added Border!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readSeaDistsIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException{
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_SEA_DISTS_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(",");
                    SeaDists seaDists = new SeaDists();
                    seaDists.setCountryOrigin(aux[0]);
                    seaDists.setPortIDOrigin(Integer.parseInt(aux[1]));
                    seaDists.setPortOrigin(aux[2]);
                    seaDists.setCountryDestiny(aux[3]);
                    seaDists.setPortIDDestiny(Integer.parseInt(aux[4]));
                    seaDists.setPortDestiny(aux[5]);
                    seaDists.setSeaDists(Integer.parseInt(aux[6]));
                    SeaDistsDB seaDistsDB = new SeaDistsDB();

                    if (!seaDistsDB.save(databaseConnection, seaDists)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added SeaDist!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readCountryIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_COUNTRY_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(",");
                    Country country = new Country();
                    country.setContinent(aux[0]);
                    country.setAlpha2code(aux[1]);
                    country.setAlpha3code(aux[2]);
                    country.setCountry(aux[3]);
                    country.setPopulation(Double.parseDouble(aux[4]));
                    country.setCapital(aux[5]);
                    country.setLat(Double.parseDouble(aux[6]));
                    country.setLon(Double.parseDouble(aux[7]));
                    CountryDB countryDB = new CountryDB();

                    if (!countryDB.save(databaseConnection, country)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added Country!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void readClientIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException{
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_CLIENT_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Client client = new Client();
                    client.setClient_ID(Integer.parseInt(aux[0]));
                    client.setName(aux[1]);
                    ClientDB clientDB = new ClientDB();

                    if (!clientDB.save(databaseConnection, client)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added Client!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readUserIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException{
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_USER_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    User user = new User();
                    user.setUsername(aux[0]);
                    user.setPassword(aux[1]);

                    user.setRole(aux[2]);
                    user.setStaffID(Integer.parseInt(aux[3]));
                    UserDB userDB = new UserDB();

                    if (!userDB.save(databaseConnection, user)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added user!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readRoleIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_ROLE_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Role role = new Role();
                    role.setRole(aux[0]);
                    RoleDB roleDB = new RoleDB();

                    if (!roleDB.save(databaseConnection, role)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added role!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readStaffIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException{
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_STAFF_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Staff staff = new Staff();
                    staff.setStaffID(Integer.parseInt(aux[0]));
                    staff.setName(aux[1]);
                    staff.setCargoManifestID(Integer.parseInt(aux[2]));
                    staff.setLocationID(aux[3]);
                    staff.setNameStop(aux[4]);
                    StaffDB staffDB = new StaffDB();

                    if (!staffDB.save(databaseConnection, staff)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added staff!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readStaffShipIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException{
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_STAFF_SHIP_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    StaffShip staffShip = new StaffShip();
                    staffShip.setmMSI(Integer.parseInt(aux[0]));
                    staffShip.setStaffID(Integer.parseInt(aux[1]));

                    StaffDB staffDB = new StaffDB();

                    if (!staffDB.saveStaffShipIntoDatabase(databaseConnection, staffShip)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added staff_ship!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }


    private void readTruckIntoDatabase(Connection connection, DatabaseConnection databaseConnection) throws FileNotFoundException {
        String[] aux;
        Scanner sc = new Scanner(new FileReader(FILE_TRUCK_SMALL));
        sc.nextLine();
        try {
            connection.setAutoCommit(false);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    aux = linha.split(";");
                    Truck truck = new Truck();
                    truck.setTruckID(Integer.parseInt(aux[0]));
                    truck.setName(aux[1]);
                    truck.setLicensePlate(Integer.parseInt(aux[2]));
                    TruckDB truckDB = new TruckDB();

                    if (!truckDB.save(databaseConnection, truck)) {
                        throw databaseConnection.getLastError();
                    }
                    connection.commit();
                    System.out.println("Added truck!");
                }
            }
            sc.close();
        } catch (SQLException ex) {
            Logger.getLogger("group101")
                    .log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger("group101")
                        .log(Level.SEVERE, null, ex1);
            }
        }
    }

}
