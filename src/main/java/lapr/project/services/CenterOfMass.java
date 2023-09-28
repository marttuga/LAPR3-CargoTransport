package lapr.project.services;


public class CenterOfMass {


    public String centerOfMassCalc(String vesselType, double cRect, double hRect, double mRect, double bTrian, double hTrian, double mTrian, double cCube, double mCube){
       double x = 0;
       double y = 0;
       double xCMRect, yCMRect;
       double xCMTrian, yCMTrian;
       double xCMCube, yCMCube;
       double type = 0;
       xCMRect = cRect/2;
       yCMRect = hRect /2;
       xCMTrian = cRect + (bTrian/3) ;
       yCMTrian = (hTrian/3) * 2;
       xCMCube = type + (cCube /2);
       yCMCube = hRect + (cCube/2);

       if(hRect == hTrian) {
           if(vesselType == "bow"){
               type = 300;
               x = ((xCMRect * mRect) + (xCMTrian * mTrian) + (xCMCube * mCube)) / (mRect + mTrian + mCube);
               y = ((yCMRect * mRect) + (yCMTrian * mTrian) + (yCMCube * mCube)) / (mRect + mTrian + mCube);
               System.out.println("The center of mass is: (" + x + "; " + y + ")");
           }else if (vesselType == "midship"){
               type = 160;
               x = ((xCMRect * mRect) + (xCMTrian * mTrian) + (xCMCube * mCube)) / (mRect + mTrian + mCube);
               y = ((yCMRect * mRect) + (yCMTrian * mTrian) + (yCMCube * mCube)) / (mRect + mTrian + mCube);
               System.out.println("The center of mass is: (" + x + "; " + y + ")");
           }
           else if(vesselType == "stern") {
               type = 30;
               x = ((xCMRect * mRect) + (xCMTrian * mTrian) + (xCMCube * mCube)) / (mRect + mTrian + mCube);
               y = ((yCMRect * mRect) + (yCMTrian * mTrian) + (yCMCube * mCube)) / (mRect + mTrian + mCube);
               System.out.println("The center of mass is: (" + x + "; " + y + ")");
           }
       }
       else return "The height of the Rectangle is different from the height of the Triangle";
        System.out.println("The height of the Rectangle is different from the height of the Triangle!");
        return "The center of mass is: (" + x + "; " + y + ")";
    }

    public String centerOfMassWithContainers(double cRect, double hRect, double mRect, double bTrian, double hTrian, double mTrian, double cCube, double mCube, int numberOfContainers, double mContainer) {

        double containersTotalMass = numberOfContainers * mContainer;
        double xCMShip;
        double yCMShip;
        double xCMContainers;
        double yCMContainers = 0;
        double xCMRect, yCMRect;
        double xCMTrian, yCMTrian;
        double xCMCube, yCMCube;
        double type = 0;
        double mTotal;
        xCMRect = cRect/2;
        yCMRect = hRect /2;
        xCMTrian = cRect + (bTrian/3) ;
        yCMTrian = (hTrian/3) * 2;
        xCMCube = type + (cCube /2);
        yCMCube = hRect + (cCube/2);

        if(hRect == hTrian) {
            xCMShip = ((xCMRect * mRect) + (xCMTrian * mTrian) + (xCMCube * mCube)) / (mRect + mTrian + mCube);
            yCMShip = ((yCMRect * mRect) + (yCMTrian * mTrian) + (yCMCube * mCube)) / (mRect + mTrian + mCube);

            mTotal = mRect + mTrian + mCube + containersTotalMass;

            xCMContainers = ((mTotal * xCMShip) - ((xCMRect * mRect) + (xCMTrian * mTrian) + (xCMCube * mCube))) / containersTotalMass;
            yCMContainers = ((mTotal * yCMShip) - ((yCMRect * mRect) + (yCMTrian * mTrian) + (yCMCube * mCube))) / containersTotalMass;

            if(xCMContainers <= cRect+hTrian && xCMContainers >= cCube){
                return "The centers of mass match!";
            }
        }else return "The height of the Rectangle is different from the height of the Triangle";

        return "The centers of mass don't match!";
    }
}
