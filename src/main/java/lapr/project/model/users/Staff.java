package lapr.project.model.users;

import java.util.Objects;

/**
 * The type Staff.
 */
public class Staff {
    private int staffID;
    private String name;
    private int cargoManifestID;
    private String locationID;
    private String nameStop;
    /**
     * Instantiates a new Staff.
     */
    public Staff(){

    }

    public Staff(int staffID, String name, int cargoManifestID, String locationID, String nameStop) {
        this.staffID = staffID;
        this.name = name;
        this.cargoManifestID = cargoManifestID;
        this.locationID = locationID;
        this.nameStop = nameStop;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCargoManifestID() {
        return cargoManifestID;
    }

    public void setCargoManifestID(int cargoManifestID) {
        this.cargoManifestID = cargoManifestID;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getNameStop() {
        return nameStop;
    }

    public void setNameStop(String nameStop) {
        this.nameStop = nameStop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return staffID == staff.staffID && cargoManifestID == staff.cargoManifestID && Objects.equals(name, staff.name) && Objects.equals(locationID, staff.locationID) && Objects.equals(nameStop, staff.nameStop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffID, name, cargoManifestID, locationID, nameStop);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID=" + staffID +
                ", name='" + name + '\'' +
                ", cargoManifestID=" + cargoManifestID +
                ", locationID='" + locationID + '\'' +
                ", nameStop='" + nameStop + '\'' +
                '}';
    }
}
