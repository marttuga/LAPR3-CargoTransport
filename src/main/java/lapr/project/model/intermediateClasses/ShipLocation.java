package lapr.project.model.intermediateClasses;


import java.util.Objects;

/**
 * The type Ship Location.
 */
public class ShipLocation {
    private int mMSI;
    private String locationID;

    public ShipLocation(){

    }

    /**
     * Instantiates a new Ship Location.
     *
     * @param mMSI       the ships' mmsi
     * @param locationID   the location id
     */
    public ShipLocation(int mMSI, String locationID) {
        this.mMSI = mMSI;
        this.locationID = locationID;
    }

    /**
     * Gets location id.
     *
     * @return the location id
     */
    public String getLocationID() {
        return locationID;
    }

    /**
     * Sets location id.
     *
     * @param locationID the location id
     */
    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    /**
     * Gets mmsi.
     *
     * @return the mmsi
     */
    public int getmMSI() {
        return mMSI;
    }

    /**
     * Sets mmsi
     *
     * @param mMSI the mMSI
     */
    public void setmMSI(int mMSI) {
        this.mMSI = mMSI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipLocation that = (ShipLocation) o;
        return mMSI == that.mMSI && locationID.equals(that.locationID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mMSI, locationID);
    }

    @Override
    public String toString() {
        return "ShipLocation:" +
                "mMSI= " + mMSI +
                ", locationID= '" + locationID + '\'' ;
    }
}
