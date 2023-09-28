package lapr.project.model.Truck;

import java.util.Objects;

/**
 * The type Truck.
 */
public class Truck {
    private int truckID;
    private int licensePlate;
    private String name;


    public Truck(){

    }

    public Truck(int truckID, int licensePlate, String name) {
        this.truckID = truckID;
        this.licensePlate = licensePlate;
        this.name = name;
    }

    public int getTruckID() {
        return truckID;
    }

    public void setTruckID(int truckID) {
        this.truckID = truckID;
    }

    public int getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(int licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "truckID=" + truckID +
                ", licensePlate=" + licensePlate +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return truckID == truck.truckID && licensePlate == truck.licensePlate && Objects.equals(name, truck.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(truckID, licensePlate, name);
    }
}
