package lapr.project.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceBetweenTwoPointsCalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void distance() {
        double lat1 = 53.32055555555556;
        double lat2 = 53.31861111111111;
        double lon1 = -1.7297222222222221;
        double lon2 = -1.6997222222222223;
        assertEquals(2.004, DistanceBetweenTwoPointsCalculator.distance(lat1, lat2, lon1, lon2));
        System.out.println("Distance is:" + DistanceBetweenTwoPointsCalculator.distance(lat1, lat2, lon1, lon2) + " KM");

        double latB1 = 56.32055555555556;
        double latB2 = 57.31861111111111;
        double lonB1 = -2.7297222222222221;
        double lonB2 = -2.6997222222222223;
        assertEquals(110.994, DistanceBetweenTwoPointsCalculator.distance(latB1, latB2, lonB1, lonB2));
        System.out.println("Distance is:" + DistanceBetweenTwoPointsCalculator.distance(latB1, latB2, lonB1, lonB2) + " KM");
    }
}