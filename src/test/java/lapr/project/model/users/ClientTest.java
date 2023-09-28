package lapr.project.model.users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void getClient_ID() {
        Client c= new Client(1,"e");
        assertEquals(1,c.getClient_ID());
    }

    @Test
    void getClient_ID2() {
        Client c= new Client(1,"e");
        assertNotEquals(2,c.getClient_ID());
    }

    @Test
    void setClient_ID() {
        Client c= new Client(1,"e");
        c.setClient_ID(2);
        assertEquals(2,c.getClient_ID());
    }

    @Test
    void getName() {
        Client c= new Client(1,"e");
        assertEquals("e",c.getName());
    }

    @Test
    void getName2() {
        Client c= new Client(1,"e");
        assertNotEquals("f",c.getName());
    }

    @Test
    void setName() {
        Client c= new Client(1,"e");
        c.setName("d");
        assertEquals("d",c.getName());
    }


    @Test
    void testEquals() {
        Client c= new Client(1,"e");
        Client y= null;
        assertNotEquals(c,y);
    }

    @Test
    void testEquals2() {
        Client c= null;
        Client y= null;
        assertEquals(c,y);
    }

    @Test
    void testEquals3() {
        Client c= new Client(1,"e");
        Client y= new Client(1,"e");
        assertEquals(c,y);
    }

    @Test
    void testHashCode() {
        Client c= new Client(1,"e");
        assertEquals(1093,c.hashCode());
    }

    @Test
    void testHashCodeNull() {
        Client c= new Client(1,"e");
        assertNotEquals(0,c.hashCode());
    }

    @Test
    void testToString() {
        Client c= new Client(1,"e");
        assertEquals("Client{client_ID=1, name='e'}",c.toString());
    }
}