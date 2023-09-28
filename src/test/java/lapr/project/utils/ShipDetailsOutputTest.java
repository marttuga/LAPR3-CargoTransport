/*
package lapr.project.utils;
import org.junit.jupiter.api.Test;

import java.io.File;



import static org.junit.jupiter.api.Assertions.*;

class ShipDetailsOutputTest {
    private ShipDetailsOutputTest() {

    }
    @Test
    void outPutDetails() {

        boolean a = ShipDetailsOutput.outPutDetails("email");
        assertTrue(a, "The email should be sent.");
        File f = new File("Ship_Details.txt");
        boolean m = f.delete();
        assertTrue(m);

        boolean b =  ShipDetailsOutput.outPutDetails(null);
        assertFalse(b, "The email shouldn't be sent!");
        File f1 = new File("Ship_Details.txt");
        boolean n=f1.exists();
        assertTrue(n);

        File f3 = new File("");
        assertFalse(f3.exists(), "The email shouldn't be sent!");
        File f2 = new File("Ship_Detailss.txt");
        boolean t=f2.exists();
        assertFalse(t);


    }
}*/
