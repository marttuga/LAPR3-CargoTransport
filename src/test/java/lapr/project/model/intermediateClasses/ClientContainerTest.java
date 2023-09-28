package lapr.project.model.intermediateClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientContainerTest {


    @Test
    void getCargoManID() {
        ClientContainer c =new ClientContainer(1,1,1);
        assertEquals(1,c.getCargoManifestID());
    }

    @Test
    void getCargoMnID2() {
        ClientContainer c =new ClientContainer(1,1,1);        assertNotEquals(2,c.getCargoManifestID());
    }

    @Test
    void setCargoManID() {
        ClientContainer c =new ClientContainer(1,1,1);
        c.setCargoManifestID(2);
        assertEquals(2,c.getCargoManifestID());
    }

    @Test
    void getContainerID() {
        ClientContainer c =new ClientContainer(1,1,1);
        assertEquals(1,c.getContainerID());
    }

    @Test
    void getContainerID2() {
        ClientContainer c =new ClientContainer(1,1,1);        assertNotEquals(2,c.getContainerID());
    }

    @Test
    void setContainerID() {
        ClientContainer c =new ClientContainer(1,1,1);
                c.setContainerID(2);
        assertEquals(2,c.getContainerID());
    }

    @Test
    void getClient_ID() {
        ClientContainer c =new ClientContainer(1,1,1);        assertEquals(1,c.getClient_ID());
    }

    @Test
    void getClient_ID2() {
        ClientContainer c =new ClientContainer(1,1,1);        assertNotEquals(3,c.getClient_ID());
    }

    @Test
    void setClient_ID() {
        ClientContainer c =new ClientContainer(1,1,1);        c.setClient_ID(2);
        assertEquals(2,c.getClient_ID());
    }

    @Test
    void testEquals() {
        ClientContainer c =new ClientContainer(1,1,1);
        ClientContainer c1 =new ClientContainer(1,1,1);        assertEquals(c,c1);
    }

    @Test
    void testEquals2() {
        ClientContainer c = null;
        ClientContainer c1 =null;
        assertEquals(c,c1);
    }

    @Test
    void testEquals3() {
        ClientContainer c =new ClientContainer(1,1,1);        ClientContainer c1 =null;
        assertNotEquals(c,c1);
    }

    @Test
    void testHashCode() {
        ClientContainer c =new ClientContainer(1,1,1);        assertEquals(30784,c.hashCode());
    }

    @Test
    void testHashCodeNull() {
        ClientContainer c =new ClientContainer(1,1,1);        assertNotEquals(0,c.hashCode());
    }

    @Test
    void testToString() {
        ClientContainer c =new ClientContainer(1,1,1);        assertEquals("ClientContainer{client_ID=1, containerID=1, cargoManifestID=1}",c.toString());
    }
}