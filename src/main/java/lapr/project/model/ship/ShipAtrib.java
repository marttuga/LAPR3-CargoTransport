package lapr.project.model.ship;

import java.util.Objects;

public class ShipAtrib {
    //codigo mmsi ship1
    private int mMSI;
    //codigo mmsi ship2
    private int mMSI1;
    //distancia percorrida ship1
    private double dDistance1;
    //distancia percorrida ship2
    private double dDistance2;
    //nr total de movimentos do ship1
    private int numberOfMovements;
    //nr total de movimentos do ship2
    private int numberOfMovements1;
    //distancia viajada do ship1
    private double travelDistance;
    //distancia viajada do ship2
    private double travelDistance1;
    //diferença entre as distancias viajadas dos dois ships
    private double travelDistanceDiference;


    public ShipAtrib(int mMSI, int mMSI1, double dDistance1, double dDistance2, int numberOfMovements, double travelDistance, int numberOfMovements1, double travelDistance1) {

        this.mMSI = mMSI;
        this.mMSI1 = mMSI1;
        this.dDistance1 = dDistance1;
        this.dDistance2 = dDistance2;
        this.numberOfMovements = numberOfMovements;
        this.numberOfMovements1 = numberOfMovements1;
        this.travelDistance = travelDistance;
        this.travelDistance1 = travelDistance1;
        this.travelDistanceDiference = travelDistance1 - travelDistance;
    }

    public ShipAtrib(int mMSI, int numberOfMovements, double travelDistance, double dDistance1) {
        this.mMSI = mMSI;
        this.dDistance1 = dDistance1;
        this.numberOfMovements = numberOfMovements;
        this.travelDistance = travelDistance;
        this.travelDistanceDiference = travelDistance1 - travelDistance;
    }

    public int getmMSI() {
        return mMSI;
    }

    public int getmMSI1() {
        return mMSI1;
    }

    public double getDDistance1() {
        return dDistance1;
    }

    public double getDDistance2() {
        return dDistance2;
    }

    public int getNumberOfMovements() {
        return numberOfMovements;
    }

    public int getNumberOfMovements1() {
        return numberOfMovements1;
    }

    public double getTravelDistance() {
        return travelDistance;
    }

    public double getTravelDistance1() {
        return travelDistance1;
    }

    public double getTravelDistanceDiference() {
        return travelDistanceDiference;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipAtrib shipAtrib = (ShipAtrib) o;
        return mMSI == shipAtrib.mMSI && mMSI1 == shipAtrib.mMSI1 && Double.compare(shipAtrib.dDistance1, dDistance1) == 0 && Double.compare(shipAtrib.dDistance2, dDistance2) == 0 && numberOfMovements == shipAtrib.numberOfMovements && numberOfMovements1 == shipAtrib.numberOfMovements1 && Double.compare(shipAtrib.travelDistance, travelDistance) == 0 && Double.compare(shipAtrib.travelDistance1, travelDistance1) == 0 && Double.compare(shipAtrib.travelDistanceDiference, travelDistanceDiference) == 0;
    }

    @Override
    public String toString() {
        return "\nMMSI:" + mMSI + " NUMBER OF MOVEMENTS:" + numberOfMovements + " TRAVELLED DISTANCE:" + travelDistance + " DELTA DISTANCE:" + dDistance1;

    }

    @Override
    public int hashCode() {
        return Objects.hash(mMSI, mMSI1, dDistance1, dDistance2, numberOfMovements, numberOfMovements1, travelDistance, travelDistance1, travelDistanceDiference);
    }
}
