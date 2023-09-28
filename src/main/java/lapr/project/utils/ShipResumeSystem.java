package lapr.project.utils;

import java.io.*;

public class ShipResumeSystem {
    private ShipResumeSystem() {
    }

    public static boolean outPutResume(String resume, int mmsi) {
        try {
            FileWriter myWriter;
            String outputLocation = null;
            outputLocation = "shipResume//" + "Ship_" + mmsi + "_Resume.txt";
            myWriter = new FileWriter(outputLocation, true);

            try {
                if (resume == null) {
                    myWriter.close();
                    File f1 = new File("shipResume//" + "Ship_" + mmsi + "_Resume.txt");
                    f1.delete();
                    return false;
                }
                myWriter.write(resume);


                myWriter.write("");
            } finally {
                myWriter.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error outputting the form request to a txt!");
            return false;
        }
        return true;
    }

}

