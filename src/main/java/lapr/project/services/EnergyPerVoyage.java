
package lapr.project.services;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class EnergyPerVoyage {

    public double finalCalcEnergy(double tempSectionsExposed, double time, int tempInt, int numberDoorsExposed, int numberLateralSidesExposed){
        double areaExposed=0;
        double resInt;
        double resMid;
        double resExt;
        double resTotalExposed=0;
        double resTotalNotExposed=0;
        double areaNotExposed=0;
        if(numberDoorsExposed <= 2 && numberLateralSidesExposed <=3){
            if (numberDoorsExposed >=0 || numberLateralSidesExposed >=0) {
                areaExposed = (Math.pow(2.34, 2) * numberDoorsExposed) + (2.34 * 12 * numberLateralSidesExposed);
                areaNotExposed = 123.2712-areaExposed;
                if (tempInt==7){
                    resInt = 0.01/(14*areaExposed);
                    resMid = 0.12/(0.04*areaExposed);
                    resExt = 0.02/(52*areaExposed);
                    resTotalExposed = BigDecimal.valueOf(resInt + resMid + resExt).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
                }else if (tempInt==-5){
                    resInt = 0.01/(14*areaExposed);
                    resMid = 0.12/(0.024*areaExposed);
                    resExt = 0.02/(52*areaExposed);
                    resTotalExposed = BigDecimal.valueOf(resInt + resMid + resExt).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
                }
                if (tempInt==7){
                    resInt = 0.01/(14*areaNotExposed);
                    resMid = 0.12/(0.04*areaNotExposed);
                    resExt = 0.02/(52*areaNotExposed);
                    resTotalNotExposed = BigDecimal.valueOf(resInt + resMid + resExt).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
                }else if (tempInt==-5){
                    resInt = 0.01/(14*areaNotExposed);
                    resMid = 0.12/(0.024*areaNotExposed);
                    resExt = 0.02/(52*areaNotExposed);
                    resTotalNotExposed = BigDecimal.valueOf(resInt + resMid + resExt).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
                }
                double energyNotExposed =BigDecimal.valueOf(energyCalc(20, time, tempInt, resTotalNotExposed)).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
                double energyExposed =BigDecimal.valueOf(energyCalc(tempSectionsExposed, time, tempInt, resTotalExposed)).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
                return BigDecimal.valueOf(energyExposed+energyNotExposed).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            }
        }
        return 0;
    }

    public double energyCalc(double tempSections, double time, int tempInt, double restTotal) {
       return ((tempSections-tempInt)/restTotal)*time;

    }


}

