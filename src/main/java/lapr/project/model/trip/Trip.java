package lapr.project.model.trip;

import java.util.Date;
import java.util.Objects;

/**
 * The type Trip.
 */
public class Trip {
    /**
     * The Trip id.
     */
    private int tripID;
    /**
     * The Start point.
     */
    private String departure;
    /**
     * The Finish point.
     */
    private String arrival;
    private Date departureDate;
    private Date arrivalDate;
    private String vehicleID;
    private String shipMMSI;

    /**
     * Instantiates a new Trip.
     */
    public Trip() {

    }

    public Trip(int tripID, String departure, String arrival, Date departureDate, Date arrivalDate, String vehicleID, String shipMMSI) {
        this.tripID = tripID;
        this.departure = departure;
        this.arrival = arrival;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.vehicleID = vehicleID;
        this.shipMMSI = shipMMSI;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getShipMMSI() {
        return shipMMSI;
    }

    public void setShipMMSI(String shipMMSI) {
        this.shipMMSI = shipMMSI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return tripID == trip.tripID && Objects.equals(departure, trip.departure) && Objects.equals(arrival, trip.arrival) && Objects.equals(departureDate, trip.departureDate) && Objects.equals(arrivalDate, trip.arrivalDate) && Objects.equals(vehicleID, trip.vehicleID) && Objects.equals(shipMMSI, trip.shipMMSI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripID, departure, arrival, departureDate, arrivalDate, vehicleID, shipMMSI);
    }

}
