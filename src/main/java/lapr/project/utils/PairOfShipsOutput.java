/*
package lapr.project.utils;

import lapr.project.model.ship.ShipAtrib;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class PairOfShipsOutput {

    public static boolean outPut(List<ShipAtrib> list) {

        try {
            FileWriter myWriter;
            String outputLocation = null;
            outputLocation = "pairOfShips//" + "Ships_Pair.txt";
            myWriter = new FileWriter(outputLocation, true);

            try {
                if (list == null || list.isEmpty()) {
                    myWriter.close();
                    File f1 = new File("pairOfShips//" + "Ships_Pair.txt");
                    f1.delete();
                    return false;
                }
                for (ShipAtrib s : list) {
                    myWriter.write(String.format("%s %-28s %-35s %-45s %-55s %-65s %-75s %-85s%n", s.getmMSI(), s.getmMSI1(), s.getDDistance1(),
                            s.getDDistance2(), s.getNumberOfMovements(), s.getTravelDistance(), s.getNumberOfMovements1(), s.getTravelDistance1()));
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
