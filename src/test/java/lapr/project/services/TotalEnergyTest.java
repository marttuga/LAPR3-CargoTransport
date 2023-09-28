
package lapr.project.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TotalEnergyTest {
    TotalEnergy totalEnergy;
    EnergyToSupply energyToSupply ;

    @BeforeEach
    void setUp() {
        totalEnergy = new TotalEnergy();
        energyToSupply = new EnergyToSupply();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void totalEnergy() {
        int containerPos1 = 20;
        int containerNeg1 = 35;

        String expected1 = totalEnergy.totalEnergyCalc(containerPos1,containerNeg1);
        assertEquals(expected1, "The total energy to be supplied to the set of containers is: 20 * 4814814.81 + 35 * 5541871.92 = 2.902618134E8J");


        int containerPos2 = 22;
        int containerNeg2 = 30;

        String expected2 = totalEnergy.totalEnergyCalc(containerPos2,containerNeg2);
        assertEquals(expected2, "The total energy to be supplied to the set of containers is: 22 * 4814814.81 + 30 * 5541871.92 = 2.7218208341999996E8J");

        int containerPos3 = 15;
        int containerNeg3 = 40;

        String expected3 = totalEnergy.totalEnergyCalc(containerPos3,containerNeg3);
        assertEquals(expected3, "The total energy to be supplied to the set of containers is: 15 * 4814814.81 + 40 * 5541871.92 = 2.9389709895E8J");


        int containerPos4 = 0;
        int containerNeg4 = 0;

        String expected4 = totalEnergy.totalEnergyCalc(containerPos4,containerNeg4);
        assertEquals(expected4, "The total energy to be supplied to the set of containers is: 0 * 4814814.81 + 0 * 5541871.92 = 0.0J");

    }
}

