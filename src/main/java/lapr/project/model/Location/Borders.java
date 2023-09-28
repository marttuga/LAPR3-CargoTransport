package lapr.project.model.Location;

import java.util.Objects;

public class Borders {

    private String countryOrigin;
    private String countryDestiny;
    private double weight;

    public Borders() {

    }

    public Borders(String countryOrigin, String countryDestiny) {
        this.countryOrigin = countryOrigin;
        this.countryDestiny = countryDestiny;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getCountryDestiny() {
        return countryDestiny;
    }

    public void setCountryDestiny(String countryDestiny) {
        this.countryDestiny = countryDestiny;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Borders)) return false;
        Borders borders = (Borders) o;
        return getCountryOrigin().equals(borders.getCountryOrigin()) &&
                getCountryDestiny().equals(borders.getCountryDestiny());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountryOrigin(), getCountryDestiny());
    }

    @Override
    public String toString() {
        return "Borders{" +
                "countryOrigin='" + countryOrigin + '\'' +
                ", countryDestiny='" + countryDestiny + '\'' +
                ", weight=" + weight +
                '}';
    }
}
