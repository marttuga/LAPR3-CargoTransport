package lapr.project.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerEquipmentNeededTest {
    PowerEquipmentNeeded powerEquipmentNeeded;

    @BeforeEach
    void setUp() {
        powerEquipmentNeeded = new PowerEquipmentNeeded();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void powerEquipmentNeededCalc() {
        String expected = "1 generator unit is enough to supply energy for the whole cargo!";
        assertEquals(expected, powerEquipmentNeeded.powerEquipmentNeededCalc());
    }
}