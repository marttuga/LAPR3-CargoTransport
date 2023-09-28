package lapr.project.utils;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ColorMapOutputTest {
private ColorMapOutputTest(){

}
    @Test
    void outPutColoredMap() {
        boolean a = ColorMapOutput.outPutColoredMap("email");
        assertTrue(a, "The email should be sent.");
        File f = new File("coloredMap//coloredMap.txt");
        boolean m = f.delete();
        assertTrue(m);

        boolean b =  ColorMapOutput.outPutColoredMap(null);
        assertFalse(b, "The email shouldn't be sent!");
        File f1 = new File("coloredMap//coloredMap.txt");
        boolean n=f1.exists();
        assertTrue(n);

        File f3 = new File("");
        assertFalse(f3.exists(), "The email shouldn't be sent!");
        File f2 = new File("coloredMap//coloredMapp.txt");
        boolean t=f2.exists();
        assertFalse(t);
    }
}