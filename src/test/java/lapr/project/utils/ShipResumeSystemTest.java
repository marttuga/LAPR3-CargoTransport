package lapr.project.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ShipResumeSystemTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shipResumeSystemTest() {


        boolean result = ShipResumeSystem.outPutResume("email", 123456789);
        assertTrue(result, "The email should be sent.");
        File f = new File("shipResume//" + "Ship_" + 123456789 + "_Resume.txt");
        boolean a = f.delete();
        assertTrue(a);
        result = ShipResumeSystem.outPutResume(null, 0);
        assertFalse(result, "The email shouldn't be sent!");
        File f1 = new File("shipResume//" + "Ship_" + 0 + "_Resume.txt");
        boolean b=f1.exists();
        assertFalse(b);

    }


}