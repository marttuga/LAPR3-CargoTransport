package lapr.project.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class GraphSystem {

    private GraphSystem() {
    }

    public static boolean outPutResume(String resume) {
        try {
            File f = new File("graph//GraphOutPut.txt");
            if (f.exists()) {
                f.delete();
            }
            FileWriter myWriter;
            String outputLocation = null;
            outputLocation = "graph//GraphOutPut.txt";
            myWriter = new FileWriter(outputLocation, true);

            try {
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



