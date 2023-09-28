package lapr.project.utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoutingAlgorithmsTest {


    @Test
    public void numberLength() {
        int a = CountingAlgorithms.numberLength(1190963);
        assertEquals(a, 7);
    }

    @Test
    public void numberAlgorithms() {
        int a = CountingAlgorithms.stringLength("A1B2C3E4F5");
        assertEquals(a, 10);
        int b = CountingAlgorithms.stringLength("A1B2C E4F5");
        assertEquals(b, 9);


    }

}