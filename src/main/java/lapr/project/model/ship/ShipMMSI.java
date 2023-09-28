package lapr.project.model.ship;

import java.util.List;
import java.util.Map;

public class ShipMMSI extends Ship implements Comparable<ShipMMSI> {
    private List<Map.Entry<Integer, ShipMMSI>> mapList;
    private double travelDistance;

    public ShipMMSI(int mMSI) {
        super();
        super.setmMSI(mMSI);
    }

    public ShipMMSI(Ship ship) {
        super(ship);
    }

    public ShipMMSI(List<Map.Entry<Integer, ShipMMSI>> mapList) {
        super();
        super.setmMSI(mapList.get(0).getKey());
        this.mapList = mapList;
    }

    public ShipMMSI(Ship ship,  double travelDistance) {
        super(ship);
        this.travelDistance=travelDistance;
    }

    public double getTravelDistance() {
        return travelDistance;
    }

    public List<Map.Entry<Integer, ShipMMSI>> getMapList() {
        return mapList;
    }

    @Override
    public int compareTo(ShipMMSI o) {
        return this.getmMSI() - o.getmMSI();
    }

    @Override
    public String toString() {
        return String.format("MMSI:%s  Travelled Distance:%s  MeanSOG:%s  VesselType:%s\n", super.getmMSI(), travelDistance, super.getsOG(), super.getVesselType());
    }



}
