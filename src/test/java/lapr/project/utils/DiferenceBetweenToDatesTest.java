package lapr.project.utils;

import lapr.project.model.ship.Ship;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DiferenceBetweenToDatesTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findDifference() throws ParseException {
        Date date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:19");
        Date date2 = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:03");
        Date date3 = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:04");
        Date date4 = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 17:16");

        assertEquals(16,DiferenceBetweenToDates.findDifference(date2, date1));
        assertEquals(12,DiferenceBetweenToDates.findDifference(date3, date4));
        assertEquals(15,DiferenceBetweenToDates.findDifference(date3,date1));
        assertEquals(3,DiferenceBetweenToDates.findDifference(date4,date1));
    }
}