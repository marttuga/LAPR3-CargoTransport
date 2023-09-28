package lapr.project.model.trip;

import java.util.Date;
import java.util.Objects;

/**
 * The type Stops.
 */
public class Stops {

    /**
     * The Name.
     */
    private String name;
    /**
     * The Trip id.
     */
    private int tripID;

    private Date departureDateStops;
    private Date arrivalDateStops;
    /**
     * Instantiates a new Stops.
     */
    public Stops(){

    }

    public Stops(String name, int tripID, Date departureDateStops, Date arrivalDateStops) {
        this.name = name;
        this.tripID = tripID;
        this.departureDateStops = departureDateStops;
        this.arrivalDateStops = arrivalDateStops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public Date getDepartureDateStops() {
        return departureDateStops;
    }

    public void setDepartureDateStops(Date departureDateStops) {
        this.departureDateStops = departureDateStops;
    }

    public Date getArrivalDateStops() {
        return arrivalDateStops;
    }

    public void setArrivalDateStops(Date arrivalDateStops) {
        this.arrivalDateStops = arrivalDateStops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stops stops = (Stops) o;
        return tripID == stops.tripID && Objects.equals(name, stops.name) && Objects.equals(departureDateStops, stops.departureDateStops) && Objects.equals(arrivalDateStops, stops.arrivalDateStops);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tripID, departureDateStops, arrivalDateStops);
    }

    @Override
    public String toString() {
        return "Stops{" +
                "name='" + name + '\'' +
                ", tripID=" + tripID +
                ", departureDateStops=" + departureDateStops +
                ", arrivalDateStops=" + arrivalDateStops +
                '}';
    }
}
