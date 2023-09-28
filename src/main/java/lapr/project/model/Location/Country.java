package lapr.project.model.Location;

import java.util.Objects;

/**
 * The type Country.
 */
public class Country {
    private String continent;
    private String alpha2code;
    private String alpha3code;
    private String country;
    private Double population;
    private String capital;
    private Double lat;
    private Double lon;

    public Country() {

    }

    public Country(String continent, String alpha2code, String alpha3code, String country, Double population, String capital, Double lat, Double lon) {
        this.continent = continent;
        this.alpha2code = alpha2code;
        this.alpha3code = alpha3code;
        this.country = country;
        this.population = population;
        this.capital = capital;
        this.lat = lat;
        this.lon = lon;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getAlpha2code() {
        return alpha2code;
    }

    public void setAlpha2code(String alpha2code) {
        this.alpha2code = alpha2code;
    }

    public String getAlpha3code() {
        return alpha3code;
    }

    public void setAlpha3code(String alpha3code) {
        this.alpha3code = alpha3code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country1 = (Country) o;
        return getContinent().equals(country1.getContinent()) &&
                getAlpha2code().equals(country1.getAlpha2code()) &&
                getAlpha3code().equals(country1.getAlpha3code()) &&
                getCountry().equals(country1.getCountry()) &&
                getPopulation().equals(country1.getPopulation()) &&
                getCapital().equals(country1.getCapital()) &&
                getLat().equals(country1.getLat()) &&
                getLon().equals(country1.getLon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContinent(), getAlpha2code(), getAlpha3code(), getCountry(), getPopulation(), getCapital(), getLat(), getLon());
    }

    @Override
    public String toString() {
        return "\nContinent: " + continent + "Alpha2 Code: " + alpha2code + "Alpha3 Code: " + alpha3code + "Country: " + country + "Population: " + population + "Capital: " + capital + "Latitude: " + lat + "Longitude: " + lon;
    }
}
