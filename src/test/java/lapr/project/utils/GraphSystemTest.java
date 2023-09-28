package lapr.project.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class GraphSystemTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void outPutResume() {
        String s = "works!!";

        boolean a = GraphSystem.outPutResume(s);
        assertTrue(a);
        File f = new File("graph//GraphOutPut.txt");
        boolean b = f.delete();
        assertTrue(b);
    }
}