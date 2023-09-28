package lapr.project.model.intermediateClasses;

import java.util.Objects;

/**
 * The type Container cargo manifest.
 */
public class ContainerCargoManifest {
    private int containerID;
    private int cargoManifestID;
    private int x;
    private int y;
    private int z;
    private String unloadingLocation;

    public ContainerCargoManifest(){

    }

    /**
     * Instantiates a new Container cargo manifest.
     *
     * @param containerID       the container id
     * @param cargoManifestID   the cargo manifest id
     * @param x                 the x
     * @param y                 the y
     * @param z                 the z
     * @param unloadingLocation the unloading location
     */
    public ContainerCargoManifest(int containerID, int cargoManifestID, int x, int y, int z, String unloadingLocation) {
        this.containerID = containerID;
        this.cargoManifestID = cargoManifestID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.unloadingLocation = unloadingLocation;
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
     * Gets cargo manifest id.
     *
     * @return the cargo manifest id
     */
    public int getCargoManifestID() {
        return cargoManifestID;
    }

    /**
     * Sets cargo manifest id.
     *
     * @param cargoManifestID the cargo manifest id
     */
    public void setCargoManifestID(int cargoManifestID) {
        this.cargoManifestID = cargoManifestID;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets z.
     *
     * @return the z
     */
    public int getZ() {
        return z;
    }

    /**
     * Sets z.
     *
     * @param z the z
     */
    public void setZ(int z) {
        this.z = z;
    }

    /**
     * Gets unloading location.
     *
     * @return the unloading location
     */
    public String getUnloadingLocation() {
        return unloadingLocation;
    }

    /**
     * Sets unloading location.
     *
     * @param unloadingLocation the unloading location
     */
    public void setUnloadingLocation(String unloadingLocation) {
        this.unloadingLocation = unloadingLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerCargoManifest that = (ContainerCargoManifest) o;
        return containerID == that.containerID && cargoManifestID == that.cargoManifestID && x == that.x && y == that.y && z == that.z && Objects.equals(unloadingLocation, that.unloadingLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(containerID, cargoManifestID, x, y, z, unloadingLocation);
    }

    @Override
    public String toString() {
        return "ContainerCargoManifest{" +
                "containerID=" + containerID +
                ", cargoManifestID=" + cargoManifestID +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", unloadingLocation='" + unloadingLocation + '\'' +
                '}';
    }
}
