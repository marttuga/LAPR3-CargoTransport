package lapr.project.model.users;

import java.util.Objects;

/**
 * The type Client.
 */
public class Client {
    private int client_ID;
    private String name;


    /**
     * Instantiates a new Client.
     */
    public Client(){

    }


    /**
     * Instantiates a new Client.
     *
     * @param client_ID the client id
     * @param name      the name
     */
    public Client(int client_ID, String name) {
        this.client_ID = client_ID;
        this.name = name;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public int getClient_ID() {
        return client_ID;
    }

    /**
     * Sets client id.
     *
     * @param client_ID the client id
     */
    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return client_ID == client.client_ID && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client_ID, name);
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_ID=" + client_ID +
                ", name='" + name + '\'' +
                '}';
    }

}
