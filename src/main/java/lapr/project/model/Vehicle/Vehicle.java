package lapr.project.model.Vehicle;

import java.util.Objects;

public class Vehicle {
    private String vehicleID;

    public Vehicle() {
    }

    public Vehicle(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleID, vehicle.vehicleID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleID);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID='" + vehicleID + '\'' +
                '}';
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }
}
