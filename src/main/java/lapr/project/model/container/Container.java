

package lapr.project.model.container;

import java.util.Objects;

/**
 * The type Container.
 */
public class Container {
    private int containerID;
    private double payload;
    private double tare;
    private double gross;
    private String type;
    private int temperature;
    private String ISOCode;


    /**
     * Instantiates a new Container.
     */
    public Container() {

    }

    /**
     * Instantiates a new Container.
     *
     * @param containerID the container id
     * @param payload     the payload
     * @param tare        the tare
     * @param gross       the gross
     * @param type        the type
     * @param temperature the temperature
     * @param ISOCode     the iso code
     */
    public Container(int containerID, double payload, double tare, double gross, String type, int temperature, String ISOCode) {
        this.containerID = containerID;
        this.payload = payload;
        this.tare = tare;
        this.gross = gross;
        this.type = type;
        this.temperature = temperature;
        this.ISOCode = ISOCode;

    }

    /**
     * Instantiates a new Container.
     *
     * @param container the container
     */
    public Container(Container container) {
        this.containerID = container.getContainerID();
        this.payload = container.getPayload();
        this.tare = container.getTare();
        this.gross = container.getGross();
        this.type = container.getType();
        this.temperature = container.getTemperature();
        this.ISOCode = container.getISOCode();
    }

    /**
     * Gets container id.
     *
     * @return the container id
     */
    public int getContainerID() {
        return containerID;
    }

    /**
     * Sets container id.
     *
     * @param containerID the container id
     */
    public void setContainerID(int containerID) {
        this.containerID = containerID;
    }

    /**
     * Gets payload.
     *
     * @return the payload
     */
    public double getPayload() {
        return payload;
    }

    /**
     * Sets payload.
     *
     * @param payload the payload
     */
    public void setPayload(double payload) {
        this.payload = payload;
    }

    /**
     * Gets tare.
     *
     * @return the tare
     */
    public double getTare() {
        return tare;
    }

    /**
     * Sets tare.
     *
     * @param tare the tare
     */
    public void setTare(double tare) {
        this.tare = tare;
    }

    /**
     * Gets gross.
     *
     * @return the gross
     */
    public double getGross() {
        return gross;
    }

    /**
     * Sets gross.
     *
     * @param gross the gross
     */
    public void setGross(double gross) {
        this.gross = gross;
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
     * Gets temperature.
     *
     * @return the temperature
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Sets temperature.
     *
     * @param temperature the temperature
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }


    /**
     * Gets iso code.
     *
     * @return the iso code
     */
    public String getISOCode() {
        return ISOCode;
    }

    /**
     * Sets iso code.
     *
     * @param ISOCode the iso code
     */
    public void setISOCode(String ISOCode) {
        this.ISOCode = ISOCode;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Container)) return false;
        Container container = (Container) o;
        return getContainerID() == container.getContainerID() &&
                Double.compare(container.getPayload(), getPayload()) == 0 &&
                Double.compare(container.getTare(), getTare()) == 0 &&
                Double.compare(container.getGross(), getGross()) == 0 &&
                getTemperature() == container.getTemperature() &&
                getType().equals(container.getType()) &&
                getISOCode().equals(container.getISOCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContainerID(), getPayload(), getTare(), getGross(), getType(), getTemperature(), getISOCode());
    }

    @Override
    public String toString() {
        return "Container{" +
                "containerID=" + containerID +
                ", payload=" + payload +
                ", tare=" + tare +
                ", gross=" + gross +
                ", type='" + type + '\'' +
                ", temperature=" + temperature +
                ", ISOCode='" + ISOCode + '\'' +
                '}';
    }
}