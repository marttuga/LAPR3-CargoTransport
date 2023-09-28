package lapr.project.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class EnergyToSupply {

    public double energyCalc(  int tempInt, double resistInt, double resistMid, double resistExt) {
        int tempExt=20;
        double time=9000;
        double restTotal = BigDecimal.valueOf(resistInt + resistMid + resistExt).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        Double result =((tempExt-tempInt)/restTotal)*time;
        return BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

}
