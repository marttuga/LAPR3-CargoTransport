package lapr.project.model.ship;

import java.util.List;
import java.util.Map;

public class ShipIMO extends Ship implements Comparable<ShipIMO> {

    private List<Map.Entry<String, ShipIMO>> mapList;

    public ShipIMO(Ship ship) {
        super(ship);
    }

    public ShipIMO(List<Map.Entry<String, ShipIMO>> mapList) {
        super();
        super.setiMO(mapList.get(0).getKey());
        this.mapList = mapList;
    }

    public List<Map.Entry<String, ShipIMO>> getMapList() {
        return mapList;
    }

    @Override
    public int compareTo(ShipIMO o) {
        return this.getiMO().compareTo(o.getiMO());
    }

    @Override
    public String toString() {
        return String.format("IMO:%s", super.getiMO());
    }

}
