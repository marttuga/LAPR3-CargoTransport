package lapr.project.model.intermediateClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerCargoManifestTest {

    @Test
    void getContainerID() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertEquals(1,c.getContainerID());
    }

    @Test
    void getContainerID2() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertNotEquals(3,c.getContainerID());
    }

    @Test
    void setContainerID() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        c.setContainerID(2);
        assertEquals(2,c.getContainerID());
    }

    @Test
    void getCargoManifestID() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertEquals(1,c.getCargoManifestID());
    }

    @Test
    void getCargoManifestID2() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertNotEquals(2,c.getCargoManifestID());
    }

    @Test
    void setCargoManifestID() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        c.setCargoManifestID(2);
        assertEquals(2,c.getCargoManifestID());
    }

    @Test
    void getX() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertEquals(1,c.getX());
    }

    @Test
    void getX2() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertNotEquals(3,c.getX());
    }

    @Test
    void setX() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        c.setX(2);
        assertEquals(2,c.getX());
    }

    @Test
    void getY() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertEquals(1,c.getY());
    }

    @Test
    void getY2() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertNotEquals(4,c.getY());
    }

    @Test
    void setY() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        c.setY(2);
        assertEquals(2,c.getY());
    }

    @Test
    void getZ() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertEquals(1,c.getZ());
    }

    @Test
    void getZ2() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertNotEquals(2,c.getZ());
    }

    @Test
    void setZ() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        c.setZ(2);
        assertEquals(2,c.getZ());
    }

    @Test
    void getUnloadingLocation() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertEquals("w",c.getUnloadingLocation());
    }

    @Test
    void getUnloadingLocation2() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertNotEquals("s",c.getUnloadingLocation());
    }

    @Test
    void setUnloadingLocation() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        c.setUnloadingLocation("y");
        assertEquals("y",c.getUnloadingLocation());
    }

    @Test
    void testEquals() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        ContainerCargoManifest c1= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertEquals(c,c1);
    }

    @Test
    void testEquals2() {
        ContainerCargoManifest c= null;
        ContainerCargoManifest c1= null;
        assertEquals(c,c1);
    }

    @Test
    void testEquals3() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        ContainerCargoManifest c1= null;
        assertNotEquals(c,c1);
    }

    @Test
    void testHashCode() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertEquals(917087255,c.hashCode());
    }

    @Test
    void testHashCodeNull() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertNotEquals(0,c.hashCode());
    }

    @Test
    void testToString() {
        ContainerCargoManifest c= new ContainerCargoManifest(1,1,1,1,1,"w");
        assertEquals("ContainerCargoManifest{" + "containerID=" + '1' + ", cargoManifestID=" + '1' +
                ", x=" + '1' + ", y=" + '1' + ", z=" + '1' + ", unloadingLocation='" + 'w' + '\'' + '}',c.toString());
    }
}