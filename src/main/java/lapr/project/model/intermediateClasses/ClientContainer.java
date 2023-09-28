package lapr.project.model.intermediateClasses;

import java.util.Objects;

/**
 * The type Client Container
 */
public class ClientContainer {
    private int client_ID;
    private int containerID;
    private int cargoManifestID;

    public ClientContainer() {

    }

    public ClientContainer(int client_ID, int containerID, int cargoManifestID) {
        this.client_ID = client_ID;
        this.containerID = containerID;
        this.cargoManifestID = cargoManifestID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientContainer that = (ClientContainer) o;
        return client_ID == that.client_ID && containerID == that.containerID && cargoManifestID == that.cargoManifestID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(client_ID, containerID, cargoManifestID);
    }

    @Override
    public String toString() {
        return "ClientContainer{" +
                "client_ID=" + client_ID +
                ", containerID=" + containerID +
                ", cargoManifestID=" + cargoManifestID +
                '}';
    }

    public int getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    public int getContainerID() {
        return containerID;
    }

    public void setContainerID(int containerID) {
        this.containerID = containerID;
    }

    public int getCargoManifestID() {
        return cargoManifestID;
    }

    public void setCargoManifestID(int cargoManifestID) {
        this.cargoManifestID = cargoManifestID;
    }
}