package lapr.project.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class vesselSinkTest {
    VesselSink vesselSink;

    @BeforeEach
    void setUp() {
        vesselSink = new VesselSink();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void vesselSinkCalc() {

        double cShip1 = 397;
        double hShip1 = 72.5;
        double wShip1 = 56;

        double expected1 = vesselSink.vesselSinkCalc(cShip1, hShip1, wShip1);
        assertEquals(15.696487663075303, expected1);


        double cShip2 = 400;
        double hShip2 = 75;
        double wShip2 = 50;

        double expected2 = vesselSink.vesselSinkCalc(cShip2, hShip2, wShip2);
        assertEquals(23.039215686274506, expected2);


        double cShip3 = -400;
        double hShip3 = 75;
        double wShip3 = 50;

        double expected3 = vesselSink.vesselSinkCalc(cShip3, hShip3, wShip3);
        assertEquals(0, expected3);



        double cShip4 = -397;
        double hShip4 = -72.5;
        double wShip4 = -56;

        double expected4 = vesselSink.vesselSinkCalc(cShip4, hShip4, wShip4);
        assertEquals(0, expected4);



        double cShip5 = 479;
        double hShip5 = -34;
        double wShip5 = -89;

        double expected5 = vesselSink.vesselSinkCalc(cShip5, hShip5, wShip5);
        assertEquals(0, expected5);

    }
}