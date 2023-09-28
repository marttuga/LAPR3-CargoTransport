package lapr.project.model.Location;

import java.util.Objects;

/**
 * The type Position.
 */
public class Position {
    private int positionID;
    private double latitude;
    private double longitude;

    public Position(){

    }

    /**
     * Instantiates a new Position.
     *
     * @param positionID the position id
     * @param latitude   the latitude
     * @param longitude  the longitude
     */
    public Position(int positionID, double latitude, double longitude) {
        this.positionID = positionID;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Gets position id.
     *
     * @return the position id
     */
    public int getPositionID() {
        return positionID;
    }

    /**
     * Sets position id.
     *
     * @param positionID the position id
     */
    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return getPositionID() == position.getPositionID() &&
                Double.compare(position.getLatitude(), getLatitude()) == 0 &&
                Double.compare(position.getLongitude(), getLongitude()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPositionID(), getLatitude(), getLongitude());
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionID=" + positionID +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
