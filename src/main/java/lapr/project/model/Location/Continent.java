package lapr.project.model.Location;

import java.util.Objects;

/**
 * The type Continent.
 */
public class Continent {
    private String continent;

    public Continent(){

    }

    /**
     * Instantiates a new Continent.
     *
     * @param continent the continent
     */
    public Continent(String continent) {
        this.continent = continent;
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
     * Sets continent.
     *
     * @param continent the continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Continent)) return false;
        Continent continent1 = (Continent) o;
        return getContinent().equals(continent1.getContinent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContinent());
    }

    @Override
    public String toString() {
        return "Continent{" +
                "continent='" + continent + '\'' +
                '}';
    }
}
