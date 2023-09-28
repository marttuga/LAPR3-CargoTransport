package lapr.project.model.users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void getRole() {
        Role r= new Role("P");
        assertEquals("P",r.getRole());
    }

    @Test
    void getRole2() {
        Role r= new Role("P");
        assertNotEquals("I",r.getRole());
    }

    @Test
    void setRole() {
        Role r= new Role("P");
        r.setRole("s");
        assertEquals("s",r.getRole());
    }

    @Test
    void testEquals() {
        Role r= new Role("P");
        Role h=null;
        assertNotEquals(h,r);
    }

    @Test
    void testEquals2() {
        Role r= null;
        Role h= null;
        assertEquals(h,r);
    }

    @Test
    void testEquals3() {
        Role r= new Role("P");
        Role h= new Role("P");
        assertEquals(h,r);
    }

    @Test
    void testHashCode() {
        Role r= new Role("P");
        assertEquals(111,r.hashCode());
    }

    @Test
    void testHashCodeNull() {
        Role r= new Role("P");
        assertNotEquals(0,r.hashCode());
    }

    @Test
    void testToString() {
        Role r= new Role("P");
        assertEquals("Role{role='P'}",r.toString());
    }
}