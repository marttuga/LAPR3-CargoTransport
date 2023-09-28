package lapr.project.model.port;

import java.util.Objects;

/**
 * The type Port.
 */
public class Port {
    private String continent;
    private String country;
    private int code;
    private String portCity;
    private double lat;
    private double lon;

    public Port(){

    }

    /**
     * Instantiates a new Port.
     *
     * @param continent the continent
     * @param country   the country
     * @param code      the code
     * @param portCity  the port city
     * @param lat       the lat
     * @param lon       the lon
     */
    public Port(String continent, String country, int code, String portCity, double lat, double lon) {
        this.continent = continent;
        this.country = country;
        this.code = code;
        this.portCity = portCity;
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * Gets continent.
     *
     * @return the continent
     */
    public String getContinent() {
        return continent;
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
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets port city.
     *
     * @return the port city
     */
    public String getPortCity() {
        return portCity;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Port)) return false;
        Port port = (Port) o;
        return code == port.code && Double.compare(port.lat, lat) == 0 && Double.compare(port.lon, lon) == 0 && Objects.equals(continent, port.continent) && Objects.equals(country, port.country) && Objects.equals(portCity, port.portCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(continent, country, code, portCity, lat, lon);
    }

    @Override
    public String toString() {
        return "Port{" +
                "continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                ", code=" + code +
                ", portCity='" + portCity + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
