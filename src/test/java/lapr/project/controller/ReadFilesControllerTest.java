
package lapr.project.controller;

import lapr.project.model.ship.ShipCallSign;
import lapr.project.model.ship.ShipIMO;
import lapr.project.model.ship.ShipMMSI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadFilesControllerTest {
    ReadFilesController readFilesController;

    @BeforeEach
    void setUp() {
        readFilesController = new ReadFilesController();
        BuildTreeController.getInstance().resetShipTrees();
    }


    @Test
    public void treeIsEmpty() {
        boolean a = BuildTreeController.getInstance().getBSTByCallSign().isEmpty();
        boolean b = BuildTreeController.getInstance().getBSTByShipMMSI().isEmpty();
        boolean c = BuildTreeController.getInstance().getBSTByShipIMO().isEmpty();
        assertTrue(a, "Should be empty");
        assertTrue(b, "Should be empty");
        assertTrue(c, "Should be empty");

        try {
            readFilesController.load();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error loading the file");
        }


      /*  System.out.println("Tree MMSI SIZE: " + BuildTreeController.getInstance().getBSTByShipMMSI().size());
        System.out.println();
        for (ShipMMSI s : BuildTreeController.getInstance().getBSTByShipMMSI().inOrder()) {
            System.out.println(s.getMapList());
        }*/
       // System.out.println();
     /*  System.out.println(BuildTreeController.getInstance().getBSTByShipIMO().size());
        System.out.println("Tree IMO SIZE: " + BuildTreeController.getInstance().getBSTByShipIMO().size());
        System.out.println();
        for (ShipIMO s : BuildTreeController.getInstance().getBSTByShipIMO().inOrder()) {
            System.out.println(s.getMapList());
        }*/
      /*  System.out.println();
        System.out.println("Tree Call Sign: " + BuildTreeController.getInstance().getBSTByCallSign().size());
        System.out.println();
        for (ShipCallSign s : BuildTreeController.getInstance().getBSTByCallSign().inOrder()) {
            System.out.println(s.getMapList());
        }*/

        boolean d = BuildTreeController.getInstance().getBSTByCallSign().isEmpty();
        boolean e = BuildTreeController.getInstance().getBSTByShipMMSI().isEmpty();
        boolean f = BuildTreeController.getInstance().getBSTByShipIMO().isEmpty();
        assertFalse(d, "Shouldn't be empty");
        assertFalse(e, "Shouldn't be empty");
        assertFalse(f, "Shouldn't be empty");

    }


    @Test
    public void treeSize() {
        readFilesController.load();

        if (!ReadFilesController.isUseBigFiles()) {
            assertEquals(22, BuildTreeController.getInstance().getBSTByShipMMSI().size());
            assertEquals(22, BuildTreeController.getInstance().getBSTByShipIMO().size());
            assertEquals(22, BuildTreeController.getInstance().getBSTByCallSign().size());

        } else {
            assertEquals(133, BuildTreeController.getInstance().getBSTByShipMMSI().size());
            assertEquals(133, BuildTreeController.getInstance().getBSTByShipIMO().size());
            assertEquals(133, BuildTreeController.getInstance().getBSTByCallSign().size());
        }
    }

    @Test
    public void checkCargo() {

        String a = "5";
        String b = "NA";
        String c = "98";
        assertEquals(readFilesController.checkCargo(a), 5);
        assertEquals(readFilesController.checkCargo(b), 0);
        assertEquals(readFilesController.checkCargo(c), 98);
    }

    @Test
    public void checkLat() {
        String a = "-91";
        String b = "-92";
        String c = "91";
        String d = "92";
        String e = "45";
        String f = "-45";

        assertEquals(-90, readFilesController.checkLat(a));
        assertEquals(-90, readFilesController.checkLat(b));
        assertEquals(90, readFilesController.checkLat(c));
        assertEquals(90, readFilesController.checkLat(d));
        assertEquals(45, readFilesController.checkLat(e));
        assertEquals(-45, readFilesController.checkLat(f));

    }

    @Test
    public void checkLon() {
        //[-180,180]
        String a = "-191";
        String b = "-192";
        String c = "191";
        String d = "192";
        String e = "45";
        String f = "-45";
        assertEquals(-180, readFilesController.checkLon(a));
        assertEquals(-180, readFilesController.checkLon(b));
        assertEquals(180, readFilesController.checkLon(c));
        assertEquals(180, readFilesController.checkLon(d));
        assertEquals(45, readFilesController.checkLon(e));
        assertEquals(-45, readFilesController.checkLon(f));
    }

    @Test
    public void checkHeading() {
        //[0,359]

        String a = "-191";
        String b = "-192";
        String c = "367";
        String d = "361";
        String e = "45";
        String f = "68";
        assertEquals(0, readFilesController.checkHeading(a));
        assertEquals(0, readFilesController.checkHeading(b));
        assertEquals(359, readFilesController.checkHeading(c));
        assertEquals(359, readFilesController.checkHeading(d));
        assertEquals(45, readFilesController.checkHeading(e));
        assertEquals(68, readFilesController.checkHeading(f));

    }
    @Test
    public void tree2DSize() {
        readFilesController.load();

        if (!ReadFilesController.isUseBigFiles()) {
            assertEquals(22, BuildTreeController.getInstance().getPort2dTree().getSize());

        } else {
            assertEquals(78, BuildTreeController.getInstance().getPort2dTree().getSize());

        }
    }

    @AfterEach
    void tearDown() {
        BuildTreeController.getInstance().resetShipTrees();
    }

}
