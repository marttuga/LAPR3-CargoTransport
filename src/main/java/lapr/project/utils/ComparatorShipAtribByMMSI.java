package lapr.project.utils;

import lapr.project.model.ship.ShipAtrib;

import java.util.Comparator;

public class ComparatorShipAtribByMMSI implements Comparator<ShipAtrib> {
    @Override
    public int compare(ShipAtrib o1, ShipAtrib o2) {
        return o1.getmMSI()-o2.getmMSI();
    }
}
