package lapr.project.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CenterOfMassTest {
    CenterOfMass centerOfMasss;

    @BeforeEach
    void setUp() {
        centerOfMasss = new CenterOfMass();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void centerOfMass() {
        String vesselType1 = "bow";
        double cRect1 = 300;
        double hRect1 = 72.5;
        double mRect1 = 25000000;
        double hTrian1 = 72.5;
        double bTrian1 = 97;
        double mTrian1 = 15000000;
        double cCube1 = 38;
        double mCube1 = 10000000;
        String expected1 = centerOfMasss.centerOfMassCalc(vesselType1 , cRect1, hRect1, mRect1, bTrian1, hTrian1, mTrian1, cCube1, mCube1);
        assertEquals("The center of mass is: (" + 178.5 + "; " + 50.925 + ")", expected1);

        String vesselType2 = "midship";
        double cRect2 = 100;
        double hRect2 = 50;
        double mRect2 = 25000000;
        double hTrian2 = 50;
        double bTrian2 = 66;
        double mTrian2 = 15000000;
        double cCube2 = 20;
        double mCube2 = 10000000;

        String expected2 = centerOfMasss.centerOfMassCalc(vesselType2 , cRect2, hRect2, mRect2, bTrian2, hTrian2, mTrian2, cCube2, mCube2);
        assertEquals("The center of mass is: (" + 63.6 + "; " + 34.5 + ")", expected2);

        String vesselType3 = "stern";
        double cRect3 = 100;
        double hRect3 = 50;
        double mRect3 = 25000000;
        double hTrian3 = 30;
        double bTrian3 = 66;
        double mTrian3 = 15000000;
        double cCube3 = 20;
        double mCube3 = 10000000;

        String expected3 = centerOfMasss.centerOfMassCalc(vesselType3 , cRect3, hRect3, mRect3, bTrian3, hTrian3, mTrian3, cCube3, mCube3);
        assertEquals("The height of the Rectangle is different from the height of the Triangle", expected3);

        String vesselType4 = "midship";
        double cRect4 = 200;
        double hRect4 = 70;
        double mRect4 = 25000000;
        double hTrian4 = 80;
        double bTrian4 = 66;
        double mTrian4 = 15000000;
        double cCube4 = 30;
        double mCube4 = 10000000;


        String expected4 = centerOfMasss.centerOfMassCalc(vesselType4 , cRect4, hRect4, mRect4, bTrian4, hTrian4, mTrian4, cCube4, mCube4);
        assertEquals("The height of the Rectangle is different from the height of the Triangle", expected4);


        String vesselType5 = "stern";
        double cRect5 = 100;
        double hRect5 = 50;
        double mRect5 = 25000000;
        double hTrian5 = 30;
        double bTrian5 = 66;
        double mTrian5 = 15000000;
        double cCube5 = 20;
        double mCube5 = 10000000;

        String expected5 = centerOfMasss.centerOfMassCalc(vesselType5 , cRect5, hRect5, mRect5, bTrian5, hTrian5, mTrian5, cCube5, mCube5);
        assertEquals("The height of the Rectangle is different from the height of the Triangle", expected5);

    }

    @Test
    void centerOfMassWithContainers() {

        double cRect1 = 100;
        double hRect1 = 50;
        double mRect1 = 25000000;
        double hTrian1 = 30;
        double bTrian1 = 66;
        double mTrian1 = 15000000;
        double cCube1 = 20;
        double mCube1 = 10000000;
        int numberOfContainers1 = 100;
        double mContainer1 = 500000;

        String expected1 = centerOfMasss.centerOfMassWithContainers(cRect1, hRect1, mRect1, bTrian1, hTrian1, mTrian1, cCube1, mCube1,numberOfContainers1,mContainer1);
        assertEquals("The height of the Rectangle is different from the height of the Triangle", expected1);

        double cRect2 = 397;
        double hRect2 = 147;
        double mRect2 = 25000000;
        double hTrian2 = 147;
        double bTrian2 = 180;
        double mTrian2 = 15000000;
        double cCube2 = 48;
        double mCube2 = 10000000;
        int numberOfContainers2 = 100;
        double mContainer2 = 500000;

        String expected2 = centerOfMasss.centerOfMassWithContainers(cRect2, hRect2, mRect2, bTrian2, hTrian2, mTrian2, cCube2, mCube2,numberOfContainers2,mContainer2);
        assertEquals("The centers of mass match!", expected2);

        double cRect3 = 397;
        double hRect3 = 147;
        double mRect3 = 25000000;
        double hTrian3 = 147;
        double bTrian3 = 180;
        double mTrian3 = 15000000;
        double cCube3 = 48;
        double mCube3 = 10000000;
        int numberOfContainers3 = 90;
        double mContainer3 = 900;

        String expected3 = centerOfMasss.centerOfMassWithContainers(cRect3, hRect3, mRect3, bTrian3, hTrian3, mTrian3, cCube3, mCube3,numberOfContainers3,mContainer3);
        assertEquals("The centers of mass match!", expected3);
    }
}