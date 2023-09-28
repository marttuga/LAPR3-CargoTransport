package lapr.project.model.ship;

import java.util.List;
import java.util.Map;

public class ShipCallSign extends Ship implements Comparable<ShipCallSign> {
    private List<Map.Entry<String, ShipCallSign>> mapList;


    public ShipCallSign(String callSign) {
        super();
        super.setCallSign(callSign);
    }

    public ShipCallSign(Ship ship) {
        super(ship);
    }

    public ShipCallSign(List<Map.Entry<String, ShipCallSign>> mapList) {
        super();
        super.setCallSign(mapList.get(0).getKey());
        this.mapList = mapList;
    }

    public List<Map.Entry<String, ShipCallSign>> getMapList() {
        return mapList;
    }

    @Override
    public int compareTo(ShipCallSign o) {
        return this.getCallSign().compareTo(o.getCallSign());
    }

    @Override
    public String toString() {
        return String.format("Call Sign:%s", super.getCallSign());
    }

}