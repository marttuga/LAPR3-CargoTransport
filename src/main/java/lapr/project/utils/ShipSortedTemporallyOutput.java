/*package lapr.project.utils;

import lapr.project.model.ship.PositionalMessage;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class ShipSortedTemporallyOutput {

    private ShipSortedTemporallyOutput(){

    }

    public static boolean outputShipSorted(List<PositionalMessage> positionsList) {

        try {
            FileWriter myWriter;
            String outputLocation = null;
            outputLocation = "PositionMessages//" + "PositionMessages.txt";
            myWriter = new FileWriter(outputLocation, true);

            try {
                if (positionsList == null || positionsList.isEmpty()) {
                    myWriter.close();
                    File f1 = new File("PositionMessages//" + "PositionMessages.txt");
                    f1.delete();
                    return false;
                }
                for (PositionalMessage p : positionsList) {
                    myWriter.write(String.format("MMSI:%S  Date:%s  Latitude:%s  Longitude:%s  SOG:%s  COG:%s  Vessel Type:%s\n", p.getmMSI(),p.getDate(), p.getLat(), p.getLon(), p.getsOG(), p.getcOG(), p.getVesselType()));
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
}*/
