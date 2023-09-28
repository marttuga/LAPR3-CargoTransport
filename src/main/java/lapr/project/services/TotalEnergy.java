package lapr.project.services;

public class TotalEnergy {
    EnergyToSupply energyToSupply = new EnergyToSupply();

    public String totalEnergyCalc(int containersPos, int containersNeg) {
        double resultTotal;
        double resultPos, resultNeg;
        double resistInt = 0.0000057944;
        double resistExt = 0.0000031201;
        double resistMid1 = 0.024336;
        double resistMid2 = 0.040561;


        if (containersPos >= 0 || containersNeg >= 0) {

            resultPos = energyToSupply.energyCalc(7, resistInt, resistMid1, resistExt);
            resultNeg = energyToSupply.energyCalc(-5, resistInt, resistMid2, resistExt);
            resultTotal = containersPos * resultPos + containersNeg * resultNeg;
            return "The total energy to be supplied to the set of containers is: "  + containersPos + " * " + resultPos +
                    " + " +   containersNeg + " * " + resultNeg + " = " + resultTotal + "J";

        } else if (containersPos == 0 && containersNeg == 0) {
            return "The total energy to be supplied to the set of containers is: 0 J";
        }
        return null;
    }
}
