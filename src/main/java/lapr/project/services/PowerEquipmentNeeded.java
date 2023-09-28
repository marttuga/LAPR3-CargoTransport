package lapr.project.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PowerEquipmentNeeded {
    EnergyPerVoyage energyPerVoyage = new EnergyPerVoyage();
    EnergyToSupply energyToSupply = new EnergyToSupply();


    public String powerEquipmentNeededCalc(){

        int maximumPower = 75000;
        double power ;
        int time = 9000;
        double nrGer;
        power = (energyToSupply.energyCalc(7,0.0000057944,0.024336,0.0000031201) * 12 + energyPerVoyage.finalCalcEnergy(23,time,-5,1,0) * 12
        + energyPerVoyage.finalCalcEnergy(23, time, 7, 1, 2) * 4
        + energyPerVoyage.finalCalcEnergy(23,time, -5, 1, 1) * 16
        + energyPerVoyage.finalCalcEnergy(23,time, 7,0,1) * 16
        + energyPerVoyage.finalCalcEnergy(23,time, -5, 0, 2) * 4) / time;

        nrGer = power / maximumPower;
        BigDecimal.valueOf(nrGer).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

        if(nrGer <= 1){
            return "1 generator unit is enough to supply energy for the whole cargo!";
        }else
            return "The ship needs " + nrGer + "to support the cargo!";
    }
}
