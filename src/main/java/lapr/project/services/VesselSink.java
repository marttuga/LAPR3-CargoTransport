package lapr.project.services;

public class VesselSink {

    public double vesselSinkCalc(double cShip, double hShip, double wShip){
        int nContainers = 4000;
        int wContainers = 5000;
        double pWater = 1.020;

        if(cShip > 0 && hShip > 0 && wShip> 0 ) {


            int wContainersTotal = nContainers * wContainers;
            double vDesloc = (wContainersTotal / 10) / pWater;

            double vShip = cShip * hShip * wShip;

            double result = (vDesloc - vShip) / (cShip * wShip);
            System.out.println("\nThe vessel sinked " + result);
            return result;
        }
        else
            return 0;
    }
}
