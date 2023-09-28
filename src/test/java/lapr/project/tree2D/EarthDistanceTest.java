package lapr.project.tree2D;

import lapr.project.utils.DistanceBetweenTwoPointsCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EarthDistanceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculate() {
        double lat1 = 53.32055555555556;
        double lat2 = 53.31861111111111;
        double lon1 = -1.7297222222222221;
        double lon2 = -1.6997222222222223;
        assertEquals(7947.6, EarthDistance.calculate(lat1, lat2, lon1, lon2));
        System.out.println("Distance is:" + EarthDistance.calculate(lat1, lat2, lon1, lon2)+ " KM");

        double latB1 = 56.32055555555556;
        double latB2 = 57.31861111111111;
        double lonB1 = -2.7297222222222221;
        double lonB2 = -2.6997222222222223;
        assertEquals(8484.634, EarthDistance.calculate(latB1, latB2, lonB1, lonB2));
        System.out.println("Distance is:" +EarthDistance.calculate(lat1, lat2, lon1, lon2)+ " KM");
    }
}