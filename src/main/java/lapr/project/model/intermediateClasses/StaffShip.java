package lapr.project.model.intermediateClasses;

import java.util.Objects;

/**
 * The type Staff Ship
 */
public class StaffShip {
    private int mMSI;
    private int staffID;

    public StaffShip(){

    }

    /**
     * Instantiates a new Staff Ship.
     *
     * @param mMSI       the ships' mmsi
     * @param staffID   the staffID
     */
    public StaffShip(int mMSI, int staffID) {
        this.mMSI = mMSI;
        this.staffID = staffID;
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

    /**
     * Gets staffID.
     *
     * @return the staffID
     */
    public int getStaffID() {
        return staffID;
    }

    /**
     * Sets staffID
     *
     * @param staffID the staffID
     */
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffShip staffShip = (StaffShip) o;
        return mMSI == staffShip.mMSI && staffID == staffShip.staffID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mMSI, staffID);
    }

    @Override
    public String toString() {
        return "StaffShip:" +
                "mMSI=" + mMSI +
                ", staffID=" + staffID;
    }
}
