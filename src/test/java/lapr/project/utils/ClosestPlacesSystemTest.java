/*
package lapr.project.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPlacesSystemTest {



    @Test
    void outPutResume() {

        boolean a = ClosestPlacesSystem.outPutResume("email");
        assertTrue(a, "The email should be sent.");
        File f = new File("closestPlaces//ClosestPlacesOutput.txt");
        boolean m = f.delete();
        assertTrue(m);

        boolean b =   ClosestPlacesSystem.outPutResume(null);
        assertFalse(b, "The email shouldn't be sent!");
        File f1 = new File("closestPlaces//ClosestPlacesOutput.txt");
        boolean n=f1.exists();
        assertTrue(n);

        File f3 = new File("");
        assertFalse(f3.exists(), "The email shouldn't be sent!");
        File f2 = new File("closestPlaces//ClosestPlacesOutpput.txt");
        boolean t=f2.exists();
        assertFalse(t);

    }
}*/
