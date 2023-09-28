
package lapr.project.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnergyPerVoyageTest {

    EnergyPerVoyage energyPerVoyage= new EnergyPerVoyage();




    @Test
    void finalCalcEnergy7() {
        assertEquals(4850961.07,energyPerVoyage.finalCalcEnergy(23,9000,7,1, 0));
        assertEquals(5061339.04,energyPerVoyage.finalCalcEnergy(23,9000,7,0, 1));
        assertEquals(5314078.88,energyPerVoyage.finalCalcEnergy(23,9000,7, 0,2));
        assertEquals(4907569.92,energyPerVoyage.finalCalcEnergy(23,9000,7, 2,0));
        assertEquals(5607232.29,energyPerVoyage.finalCalcEnergy(23,9000,7, 1,3));
        assertEquals(5412487.75,energyPerVoyage.finalCalcEnergy(23,9000,7, 2,2));
        assertEquals(5566400.26,energyPerVoyage.finalCalcEnergy(23,9000,7, 0,3));
        assertEquals(5665909.39,energyPerVoyage.finalCalcEnergy(23,9000,7, 2,3));
        assertEquals(5103275.57,energyPerVoyage.finalCalcEnergy(23,9000,7, 1,1));
        assertEquals(5359342.92,energyPerVoyage.finalCalcEnergy(23,9000,7, 1,2));
    }


    @Test
    void finalCalcEnergy_5() {
        assertEquals(5570040.13,energyPerVoyage.finalCalcEnergy(23,9000,-5,1, 0));
        assertEquals(5700649.72,energyPerVoyage.finalCalcEnergy(23,9000,-5,0, 1));
        assertEquals(5848417.06,energyPerVoyage.finalCalcEnergy(23,9000,-5, 0,2));
        assertEquals(5607964.32,energyPerVoyage.finalCalcEnergy(23,9000,-5, 2,0));
        assertEquals(6034304.1,energyPerVoyage.finalCalcEnergy(23,9000,-5, 1,3));
        assertEquals(5907802.86,energyPerVoyage.finalCalcEnergy(23,9000,-5, 2,2));
        assertEquals(5998864.52,energyPerVoyage.finalCalcEnergy(23,9000,-5, 0,3));
        assertEquals(6063335.2,energyPerVoyage.finalCalcEnergy(23,9000,-5, 2,3));
        assertEquals(5730772.47,energyPerVoyage.finalCalcEnergy(23,9000,-5, 1,1));
        assertEquals(5881627.62,energyPerVoyage.finalCalcEnergy(23,9000,-5, 1,2));
    }

    @Test
    void energyCalc() {
        assertEquals(213464.6962233169,energyPerVoyage.energyCalc(20,9000,7,0.5481));
    }

}
