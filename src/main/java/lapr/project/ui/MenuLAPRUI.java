package lapr.project.ui;

import lapr.project.services.CenterOfMass;
import lapr.project.services.ControlBridge;
import lapr.project.services.VesselSink;
import lapr.project.tree.Utils;


public class MenuLAPRUI {
    ControlBridge controlBridge = new ControlBridge();
    CenterOfMass centerOfMass = new CenterOfMass();
    VesselSink vesselSink = new VesselSink();

    public MenuLAPRUI() {
        //do nothing because i just need this class to use the run method
    }

    public void run() {
        boolean continueRun;

        do {
            continueRun = false;
            int opt = 0;
            System.out.println("Choose the option: \n");
            opt = Utils.readIntegerFromConsole("1- US417\n2- US418\n3- US419\n4- US420\n0- QUIT");

            if (opt != 0) {
                if (opt == 1) {
                    controlBridge.choosePosition(Utils.readLineFromConsole("Type the position: \n Select one of the following: (Type bow/midship/stern)"));
                    if (Utils.confirm("Go to main menu?(y/n)")) {
                        continueRun = true;
                    } else break;
                }
                if (opt == 2) {
                    //String vesselType, double cRect, double hRect, double mRect, double bTrian, double hTrian, double mTrian, double cCube, double mCube
                    String vesselType = Utils.readLineFromConsole("Type of vessel (bow/midship/stern): \n");
                    double cRect = Utils.readDoubleFromConsole("Length of rectangle portion of the ship: \n");
                    double hRect = Utils.readDoubleFromConsole("Height of rectangle portion of the ship: \n");
                    double mRect = Utils.readDoubleFromConsole("Mass of the ship: \n");
                    double bTrian = Utils.readDoubleFromConsole("Length of the bow: \n");
                    double hTrian = Utils.readDoubleFromConsole("Height of the bow: \n");
                    double mTrian = Utils.readDoubleFromConsole("Mass of the bow: \n");
                    double cCube = Utils.readDoubleFromConsole("Height of the tower bridge: \n");
                    double mCube = Utils.readDoubleFromConsole("Mass of the tower bridge: \n");
                    System.out.println(centerOfMass.centerOfMassCalc(vesselType, cRect, hRect, mRect, bTrian, hTrian, mTrian, cCube, mCube));
                    if (Utils.confirm("Go to main menu?(y/n)")) {
                        continueRun = true;
                    } else break;
                }
                if (opt == 3) {
                    double cRect1 = Utils.readDoubleFromConsole("Length of rectangle portion of the ship: \n");
                    double hRect1 = Utils.readDoubleFromConsole("Height of rectangle portion of the ship: \n");
                    double mRect1 = Utils.readDoubleFromConsole("Mass of the ship: \n");
                    double bTrian1 = Utils.readDoubleFromConsole("Length of the bow: \n");
                    double hTrian1 = Utils.readDoubleFromConsole("Height of the bow: \n");
                    double mTrian1 = Utils.readDoubleFromConsole("Mass of the bow: \n");
                    double cCube1 = Utils.readDoubleFromConsole("Height of the tower bridge: \n");
                    double mCube1 = Utils.readDoubleFromConsole("Mass of the tower bridge: \n");
                    int numberOfContainers = Utils.readIntegerFromConsole("Number of containers: \n");
                    double mContainer = Utils.readDoubleFromConsole("Mass of the container: \n");
                    System.out.println(centerOfMass.centerOfMassWithContainers(cRect1, hRect1, mRect1, bTrian1, hTrian1, mTrian1, cCube1,
                            mCube1, numberOfContainers, mContainer));
                    if (Utils.confirm("Go to main menu?(y/n)")) {
                        continueRun = true;
                    } else break;
                }
                if (opt == 4) {
                    double cShip = Utils.readDoubleFromConsole("Length of the ship: \n");
                    double hShip = Utils.readDoubleFromConsole("Height of the ship: \n");
                    double wShip = Utils.readDoubleFromConsole("Mass of the ship: \n");
                    vesselSink.vesselSinkCalc(cShip, hShip, wShip);
                    if (Utils.confirm("Go to main menu?(y/n)")) {
                        continueRun = true;
                    } else break;
                }
            }
        }while(continueRun);
    }
}


