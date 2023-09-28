package lapr.project.controller;

import lapr.project.services.GraphMatrixCreate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class BuildMatrixGraphControllerTest {


    @Test
    void loadGraph() throws SQLException, IOException {
        BuildMatrixGraphController.getInstance().loadGraph();
        //System.out.println(BuildMatrixGraphController.getInstance().getLocationMap().toString());
        assertFalse(BuildMatrixGraphController.getInstance().getCapitals().isEmpty());
        assertFalse(BuildMatrixGraphController.getInstance().getPositionPorts().isEmpty());
        assertFalse(BuildMatrixGraphController.getInstance().getCountries().isEmpty());
        assertFalse(BuildMatrixGraphController.getInstance().getCountriesBorders().isEmpty());
        assertFalse(BuildMatrixGraphController.getInstance().getSeaDists().isEmpty());
        assertFalse(BuildMatrixGraphController.getInstance().getPorts().isEmpty());
        assertFalse(BuildMatrixGraphController.getInstance().getPositionsCapitals().isEmpty());

        assertFalse(BuildMatrixGraphController.getInstance().getLocationMap().edges().isEmpty());
        assertFalse(BuildMatrixGraphController.getInstance().getLocationMap().vertices().isEmpty());
    }

    @Test
    void addCapital() {

    }

    @Test
    void addCapitalConnections() {
    }

    @Test
    void addPorts() {
    }

    @Test
    void addPortsConnections() {
    }

    @Test
    void addConnectionBetweenCapitalAndPort() {
    }

    @Test
    void loadDataFromDb() {
    }

    @Test
    void getLocationMap() {
    }

    @Test
    void getPorts() {
    }

    @Test
    void getCountries() {
    }

    @Test
    void getCapitals() {
    }

    @Test
    void getPositionsCapitals() {
    }

    @Test
    void getCountriesBorders() {
    }

    @Test
    void getSeaDists() {
    }


}