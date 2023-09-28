package lapr.project.model.users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    @Test
    void getStaffID() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertEquals(1,s.getStaffID());
    }

    @Test
    void getStaffID2() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertNotEquals(2,s.getStaffID());
    }

    @Test
    void setStaffID() {
        Staff s= new Staff(1,"s",1,"w","w");
        s.setStaffID(2);
        assertEquals(2,s.getStaffID());
    }

    @Test
    void getName() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertEquals("s",s.getName());
    }

    @Test
    void getName2() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertNotEquals("y",s.getName());
    }
    @Test
    void setName() {
        Staff s= new Staff(1,"s",1,"w","w");
        s.setName("x");
        assertEquals("x",s.getName());
    }
    @Test
    void setNameStop() {
        Staff s= new Staff(1,"s",1,"w","w");
        s.setNameStop("x");
        assertEquals("x",s.getNameStop());
    }
    @Test
    void getNameStop() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertEquals("w",s.getNameStop());
    }

    @Test
    void getName2Stop() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertNotEquals("y",s.getNameStop());
    }



    @Test
    void getCargoManifestID() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertEquals(1,s.getStaffID());
    }

    @Test
    void getCargoManifestID2() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertNotEquals(2,s.getStaffID());
    }

    @Test
    void setCargoManifestID() {
        Staff s= new Staff(1,"s",1,"w","w");
        s.setCargoManifestID(2);
        assertEquals(2,s.getCargoManifestID());
    }

    @Test
    void getLocationID() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertEquals("w",s.getLocationID());
    }

    @Test
    void getLocationID2() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertNotEquals("r",s.getLocationID());
    }

    @Test
    void setLocationID() {
        Staff s= new Staff(1,"s",1,"w","w");
        s.setLocationID("e");
        assertEquals("e",s.getLocationID());
    }

    @Test
    void testEquals() {
        Staff s= new Staff(1,"s",1,"w","w");
        Staff F=null;
        assertNotEquals(s,F);
    }

    @Test
    void testEquals2() {
        Staff s= null;
        Staff F=null;
        assertEquals(s,F);
    }

    @Test
    void testEquals3() {
        Staff s= new Staff(1,"s",1,"w","w");
        Staff F=new Staff(1,"s",1,"w","w");
        assertEquals(s,F);
    }

    @Test
    void testHashCode() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertEquals(32983406,s.hashCode());
    }

    @Test
    void testHashCodeNull() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertNotEquals(0,s.hashCode());
    }

    @Test
    void testToString() {
        Staff s= new Staff(1,"s",1,"w","w");
        assertEquals("Staff{staffID=1, name='s', cargoManifestID=1, locationID='w', nameStop='w'}",s.toString());
    }
}