package lapr.project.utils;

import lapr.project.model.ship.ShipAtrib;

import java.util.Comparator;

public class ComparatorShipAtribDescByTraveledDistance implements Comparator<ShipAtrib> {
    @Override
    public int compare(ShipAtrib o1, ShipAtrib o2) {
        return (int) (o2.getTravelDistance()-o1.getTravelDistance());
    }
}
