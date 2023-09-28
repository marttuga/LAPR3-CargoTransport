
package lapr.project.ui;

import lapr.project.services.EnergyPerVoyage;
import lapr.project.services.EnergyToSupply;
import lapr.project.services.PowerEquipmentNeeded;
import lapr.project.services.TotalEnergy;
import lapr.project.tree.Utils;

public class MenuFSIAPUI {

    EnergyToSupply energyToSupply = new EnergyToSupply();
    TotalEnergy totalEnergy = new TotalEnergy();
    EnergyPerVoyage energyPerVoyage = new EnergyPerVoyage();
    PowerEquipmentNeeded powerEquipmentNeeded = new PowerEquipmentNeeded();

    public MenuFSIAPUI(){
        //do nothing because i just need this class to use the run method
    }

    public void run() {
        boolean continueRun;

        do {
            continueRun = false;
            int opt = 0;
            System.out.println("Choose the option: \n");
            opt = Utils.readIntegerFromConsole("1- US412\n2- US413\n3- US414\n4- US415\n0- QUIT");

            if (opt != 0) {
                if (opt ==1){
                    int tempInt = Utils.readIntegerFromConsole("Container interior temperature: \n");
                    double resInt = Utils.readDoubleFromConsole("Interior layer resistance: \n");
                    double resMid = Utils.readDoubleFromConsole("Middle layer resistance: \n");
                    double restExt = Utils.readDoubleFromConsole("Exterior layer resistance: \n");
                    System.out.println(energyToSupply.energyCalc(tempInt, resInt, resMid, restExt));
                    if(Utils.confirm("Go to main menu?(y/n)")){
                        continueRun = true;
                    }else break;
                }else if (opt == 2){
                    int containersPos = Utils.readIntegerFromConsole("Number of containers that interior temperature equals 7º: \n");
                    int containersNeg = Utils.readIntegerFromConsole("Number of containers that interior temperature equals -5º: \n");
                    totalEnergy.totalEnergyCalc(containersPos, containersNeg);
                    System.out.println(totalEnergy.totalEnergyCalc(containersPos, containersNeg));
                    if(Utils.confirm("Go to main menu?(y/n)")){
                        continueRun = true;
                    }else break;
                }else if (opt==3){
                    int tempSectionsExterior = Utils.readIntegerFromConsole("At What temperature are the containers exposed to in the sun?: \n");
                    double time = Utils.readDoubleFromConsole("Duration of the trip? (In seconds): \n");
                    int tempInterior = Utils.readIntegerFromConsole("Interior temperature of the container: \n");
                    int numDoorsExposed = Utils.readIntegerFromConsole("Number of doors exposed to the sun? \n");
                    int numSidesExposed = Utils.readIntegerFromConsole("Number of sides exposed to the sun? \n");
                    System.out.println(energyPerVoyage.finalCalcEnergy(tempSectionsExterior, time, tempInterior, numDoorsExposed, numSidesExposed));
                    if(Utils.confirm("Go to main menu?(y/n)")){
                        continueRun = true;
                    }else break;
                }else if (opt==4){
                    System.out.println("For 1 ship with 64 containers: \n");
                    System.out.println(powerEquipmentNeeded.powerEquipmentNeededCalc());
                    if(Utils.confirm("Go to main menu?(y/n)")){
                        continueRun = true;
                    }else break;
                }
            }
        } while (continueRun);
    }
}

