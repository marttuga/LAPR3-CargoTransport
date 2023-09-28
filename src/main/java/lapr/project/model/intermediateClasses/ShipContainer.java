package lapr.project.model.intermediateClasses;

import lapr.project.model.ship.Ship;

import java.util.Objects;



/**
 * The type Ship container.
 */
public class ShipContainer {
    private int containerID;
    private int mMSI;

    public ShipContainer(){

    }

    /**
     * Instantiates a new Ship container.
     *
     * @param containerID the container id
     * @param mMSI        the m msi
     */
    public ShipContainer(int containerID, int mMSI) {
        this.containerID = containerID;
        this.mMSI = mMSI;
    }

    /**
     * Gets container id.
     *
     * @return the container id
     */
    public int getContainerID() {
        return containerID;
    }

    /**
     * Sets container id.
     *
     * @param containerID the container id
     */
    public void setContainerID(int containerID) {
        this.containerID = containerID;
    }

    /**
     * Gets msi.
     *
     * @return the msi
     */
    public int getmMSI() {
        return mMSI;
    }

    /**
     * Sets msi.
     *
     * @param mMSI the m msi
     */
    public void setmMSI(int mMSI) {
        this.mMSI = mMSI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipContainer that = (ShipContainer) o;
        return containerID == that.containerID && mMSI == that.mMSI;
    }

    @Override
    public int hashCode() {
        return Objects.hash(containerID, mMSI);
    }

    @Override
    public String toString() {
        return "ShipContainer{" +
                "containerID=" + containerID +
                ", mMSI=" + mMSI +
                '}';
    }
}
