/*
package lapr.project.utils;
import lapr.project.model.ship.ShipAtrib;

import java.io.*;
import java.util.List;

*/
/**
 * The type List mmtddd output.
 *//*

public class ListMMTDDDOutput {
    */
/**
     * Out put list boolean.
     *
     * @param list the list
     * @return the boolean
     *//*

    public static boolean outPutList(List<ShipAtrib> list) {
        try {
            FileWriter myWriter;
            String outputLocation = "List_MMSI_Mov_TravDist_DelDist.txt";
            myWriter = new FileWriter(outputLocation, true);
            try {
                if (list == null || list.isEmpty()) {
                    myWriter.close();
                    File f1 = new File("List_MMSI_Mov_TravDist_DelDist.txt");
                    f1.delete();
                    return false;
                }
                for (ShipAtrib s : list) {
                    myWriter.write("\nMMSI:" + s.getmMSI() + " NUMBER OF MOVEMENTS:" + s.getNumberOfMovements() +
                            " TRAVELLED DISTANCE:" + s.getTravelDistance() + " DELTA DISTANCE:" + s.getDDistance1());
                }
                myWriter.write("");
            } finally {
                myWriter.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
*/
