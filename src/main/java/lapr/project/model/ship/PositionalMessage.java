package lapr.project.model.ship;

import java.util.Date;
import java.util.Objects;

/**
 * The type Positional message.
 */
public class PositionalMessage {
    private int mMSI;
    private int vesselType;
    private Date date;
    private double lat;
    private double lon;
    private double sOG;
    private double cOG;


    /**
     * Instantiates a new Positional message.
     *
     * @param mMSI       the m msi
     * @param vesselType the vessel type
     * @param date       the date
     * @param lat        the lat
     * @param lon        the lon
     */
    public PositionalMessage(int mMSI, int vesselType, double sOG, double cOG, Date date, double lat, double lon){
        this.mMSI=mMSI;
        this.vesselType=vesselType;
        this.date=date;
        this.sOG=sOG;
        this.cOG=cOG;
        this.lat=lat;
        this.lon=lon;
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
     * Gets vessel type.
     *
     * @return the vessel type
     */
    public int getVesselType() {
        return vesselType;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets SOG.
     *
     * @return the SOG
     */
    public double getsOG() {
        return sOG;
    }

    /**
     * Gets COG.
     *
     * @return the Cog
     */
    public double getcOG() {
        return cOG;
    }

    /**
     * Gets lat.
     *
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * Gets lon.
     *
     * @return the lon
     */
    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "PositionalMessage{" +
                "MMSI:" + mMSI +
                "| Vessel Type:" + vesselType +
                "| Date:" + date +
                "| SOG:" + sOG +
                "| COG:" + cOG +
                "| Lat:" + lat +
                "| Lon:" + lon +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionalMessage)) return false;
        PositionalMessage that = (PositionalMessage) o;
        return getmMSI() == that.getmMSI() &&
                getVesselType() == that.getVesselType() &&
                Double.compare(that.getsOG(), getsOG()) == 0 &&
                Double.compare(that.getcOG(), getcOG()) == 0 &&
                Double.compare(that.getLat(), getLat()) == 0 &&
                Double.compare(that.getLon(), getLon()) == 0 &&
                getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getmMSI(), getVesselType(), getsOG(), getcOG(), getDate(), getLat(), getLon());
    }
}
