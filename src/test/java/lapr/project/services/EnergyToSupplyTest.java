
package lapr.project.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnergyToSupplyTest {

    EnergyToSupply energyToSupply= new EnergyToSupply();
    @Test
    void energyCalc7() {
        assertEquals(4814814.81,energyToSupply.energyCalc(7,0.0000057944,0.024336,0.0000031201));
    }
    @Test
    void energyCalc5() {

        assertEquals(5541871.92,energyToSupply.energyCalc(-5,0.0000057944,0.040561, 0.0000031201));

    }
}
