package lapr.project.model.Location;

import java.util.Objects;

/**
 * The type Location.
 */
public class Location {

    /**
     * The Location id.
     */
    private String locationID;
    /**
     * The Type.
     */
    private String type;
    /**
     * The Name.
     */
    private String name;
    /**
     * The Position id.
     */
    private int positionID;
    /**
     * The Country.
     */
    private String country;
    /**
     * The Trip id.
     */
    private int tripID;
    /**
     * The Capacity
     */
    private int capacity;

    /**
     * Instantiates a new Location.
     */
    public Location(){

    }

    /**
     * Instantiates a new Location.
     *
     * @param locationID the location id
     * @param type       the type
     * @param name       the name
     * @param positionID the position id
     * @param country    the country
     * @param tripID     the trip id
     */
    public Location(String locationID, String type, String name, int positionID, String country, int tripID, int capacity) {
        this.locationID = locationID;
        this.type = type;
        this.name = name;
        this.positionID = positionID;
        this.country = country;
        this.tripID = tripID;
        this.capacity = capacity;
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
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets trip id.
     *
     * @return the trip id
     */
    public int getTripID() {
        return tripID;
    }

    /**
     * Sets trip id.
     *
     * @param tripID the trip id
     */
    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * Sets capacity.
     *
     * @param capacity the capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getPositionID() == location.getPositionID() &&
                getTripID() == location.getTripID() &&
                getLocationID().equals(location.getLocationID()) &&
                getType().equals(location.getType()) &&
                getName().equals(location.getName()) &&
                getCountry().equals(location.getCountry()) &&
                getCapacity() == (location.getCapacity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocationID(), getType(), getName(), getPositionID(), getCountry(), getTripID(), getCapacity());
    }

    @Override
    public String toString() {
        return "\n"+"Location{" +
                "locationID='" + locationID + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", positionID=" + positionID +
                ", country='" + country + '\'' +
                ", tripID=" + tripID +
                ", capacity=" + capacity +
                '}'+"\n";
    }
}
