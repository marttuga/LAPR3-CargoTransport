
package lapr.project.model.cargoManifest;

import java.util.Date;
import java.util.Objects;

/**
 * The type Cargo manifest.
 */
public class CargoManifest {

    private int cargoManifestID;
    private int grossWeight;
    private Date manifestDate;
    private String type;
    private String stopName;
    private String vehicleID;
    public CargoManifest(){

    }

    public int getCargoManifestID() {
        return cargoManifestID;
    }

    public void setCargoManifestID(int cargoManifestID) {
        this.cargoManifestID = cargoManifestID;
    }

    public int getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(int grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Date getManifestDate() {
        return manifestDate;
    }

    public void setManifestDate(Date manifestDate) {
        this.manifestDate = manifestDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoManifest that = (CargoManifest) o;
        return cargoManifestID == that.cargoManifestID && grossWeight == that.grossWeight && Objects.equals(manifestDate, that.manifestDate) && Objects.equals(type, that.type) && Objects.equals(stopName, that.stopName) && Objects.equals(vehicleID, that.vehicleID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargoManifestID, grossWeight, manifestDate, type, stopName, vehicleID);
    }

    public CargoManifest(int cargoManifestID, int grossWeight, Date manifestDate, String type, String stopName, String vehicleID) {
        this.cargoManifestID = cargoManifestID;
        this.grossWeight = grossWeight;
        this.manifestDate = manifestDate;
        this.type = type;
        this.stopName = stopName;
        this.vehicleID = vehicleID;
    }

    @Override
    public String toString() {
        return "CargoManifest{" +
                "cargoManifestID=" + cargoManifestID +
                ", grossWeight=" + grossWeight +
                ", manifestDate=" + manifestDate +
                ", type='" + type + '\'' +
                ", stopName='" + stopName + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                '}';
    }
}

