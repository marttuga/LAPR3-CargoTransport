package lapr.project.controller;

import lapr.project.model.port.Port;
import lapr.project.tree2D.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildTreeControllerTest {
    ReadFilesController readFilesController;

    @BeforeEach
    void setUp() {
        readFilesController = new ReadFilesController();

    }

    @AfterEach
    void tearDown() {
        BuildTreeController.getInstance().resetShipTrees();
    }

    @Test
    void getNodeList() throws ParseException {
        readFilesController.load();
        if (!ReadFilesController.isUseBigFiles()) {
            assertEquals(22, BuildTreeController.getInstance().getPortNodeList().size());

        } else {
            assertEquals(78, BuildTreeController.getInstance().getPortNodeList().size());

        }
    }

    @Test
    void fillPortNodeList() throws ParseException {
        BuildTreeController.getInstance().reset2DPortTree();

        BuildTreeController.getInstance().fillPortNodeList("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65);
        assertEquals(1, BuildTreeController.getInstance().getPortNodeList().size());
        BuildTreeController.getInstance().fillPortNodeList("Europe", "Malta", 10138, "Marsaxlokk", 35.84194, 14.54306);
        assertEquals(2, BuildTreeController.getInstance().getPortNodeList().size());


    }

    @Test
    void build2DPortTree() throws ParseException {
        BuildTreeController.getInstance().reset2DPortTree();

        BuildTreeController.getInstance().build2DPortTree();
        assertEquals(0, BuildTreeController.getInstance().getPort2dTree().getSize());
        readFilesController.load();
        if (!ReadFilesController.isUseBigFiles()) {
            assertEquals(22, BuildTreeController.getInstance().getPort2dTree().getSize());

        } else {
            assertEquals(78, BuildTreeController.getInstance().getPort2dTree().getSize());

        }
    }

    @Test
    void creatShipTree() throws ParseException {
        boolean a = BuildTreeController.getInstance().getBSTByShipMMSI().isEmpty();
        boolean b = BuildTreeController.getInstance().getBSTByShipIMO().isEmpty();
        boolean c = BuildTreeController.getInstance().getBSTByCallSign().isEmpty();
        assertTrue(a);
        assertTrue(b);
        assertTrue(c);

        BuildTreeController.getInstance().creatShipTree(210950000, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5, 76, "B","12345");
        BuildTreeController.getInstance().creatShipTree(111111111, new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "VARAMO", "IMO1111111", "C1111", 70, 166, 25, 9.5, 76, "B","12345");

        assertEquals(1, BuildTreeController.getInstance().getBSTByShipMMSI().size());
        assertEquals(1, BuildTreeController.getInstance().getBSTByShipIMO().size());
        assertEquals(1, BuildTreeController.getInstance().getBSTByCallSign().size());
        readFilesController.load();


    }
}