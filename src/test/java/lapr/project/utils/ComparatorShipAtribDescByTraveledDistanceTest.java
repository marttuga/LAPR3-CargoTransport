package lapr.project.utils;

import lapr.project.model.ship.ShipAtrib;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorShipAtribDescByTraveledDistanceTest {

    @Test
    void compare() {
        double d1 = 1.595;
        ShipAtrib ship1 = new ShipAtrib(366759530, 366772990, d1, d1, 1217, 78.724, 1251, 360.596);
        ShipAtrib ship2 = new ShipAtrib(563076200, 636015975, d1, d1, 808, 220.471, 836, 153.906);
        List<ShipAtrib> al = new LinkedList<>();
        al.add(ship1);
        al.add(ship2);
        Collections.sort(al, new ComparatorShipAtribDescByTraveledDistance());
        List<ShipAtrib> bl = new LinkedList<>();
        bl.add(ship2);
        bl.add(ship1);
        assertEquals(bl, al);
    }


}