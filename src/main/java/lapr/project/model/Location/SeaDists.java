package lapr.project.model.Location;

import java.util.Objects;

public class SeaDists {
    private String CountryOrigin;
    private int portIDOrigin;
    private String portOrigin;
    private String CountryDestiny;
    private int portIDDestiny;
    private String portDestiny;
    private int seaDists;

    public SeaDists(){

    }
    public SeaDists(String countryOrigin, int portIDOrigin, String portOrigin, String countryDestiny, int portIDDestiny, String portDestiny, int seaDists) {
        CountryOrigin = countryOrigin;
        this.portIDOrigin = portIDOrigin;
        this.portOrigin = portOrigin;
        CountryDestiny = countryDestiny;
        this.portIDDestiny = portIDDestiny;
        this.portDestiny = portDestiny;
        this.seaDists = seaDists;
    }

    public String getCountryOrigin() {
        return CountryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        CountryOrigin = countryOrigin;
    }

    public int getPortIDOrigin() {
        return portIDOrigin;
    }

    public void setPortIDOrigin(int portIDOrigin) {
        this.portIDOrigin = portIDOrigin;
    }

    public String getPortOrigin() {
        return portOrigin;
    }

    public void setPortOrigin(String portOrigin) {
        this.portOrigin = portOrigin;
    }

    public String getCountryDestiny() {
        return CountryDestiny;
    }

    public void setCountryDestiny(String countryDestiny) {
        CountryDestiny = countryDestiny;
    }

    public int getPortIDDestiny() {
        return portIDDestiny;
    }

    public void setPortIDDestiny(int portIDDestiny) {
        this.portIDDestiny = portIDDestiny;
    }

    public String getPortDestiny() {
        return portDestiny;
    }

    public void setPortDestiny(String portDestiny) {
        this.portDestiny = portDestiny;
    }

    public int getSeaDists() {
        return seaDists;
    }

    public void setSeaDists(int seaDists) {
        this.seaDists = seaDists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeaDists)) return false;
        SeaDists seaDists1 = (SeaDists) o;
        return getPortIDOrigin() == seaDists1.getPortIDOrigin() &&
                getPortIDDestiny() == seaDists1.getPortIDDestiny() &&
                getSeaDists() == seaDists1.getSeaDists() &&
                getCountryOrigin().equals(seaDists1.getCountryOrigin()) &&
                getPortOrigin().equals(seaDists1.getPortOrigin()) &&
                getCountryDestiny().equals(seaDists1.getCountryDestiny()) &&
                getPortDestiny().equals(seaDists1.getPortDestiny());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountryOrigin(), getPortIDOrigin(), getPortOrigin(), getCountryDestiny(), getPortIDDestiny(), getPortDestiny(), getSeaDists());
    }

    @Override
    public String toString() {
        return "SeaDists{" +
                "CountryOrigin='" + CountryOrigin + '\'' +
                ", portIDOrigin=" + portIDOrigin +
                ", portOrigin='" + portOrigin + '\'' +
                ", CountryDestiny='" + CountryDestiny + '\'' +
                ", portIDDestiny=" + portIDDestiny +
                ", portDestiny='" + portDestiny + '\'' +
                ", seaDists=" + seaDists +
                '}';
    }
}
