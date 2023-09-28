package lapr.project.utils;

import lapr.project.model.ship.ShipMMSI;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class TopNShipsOutput {
    private TopNShipsOutput(){

    }
    public static boolean outputTopNShips (List<Map.Entry<Integer, List<ShipMMSI>>> groupedList){
        try {
            FileWriter myWriter;
            String outputLocation = null;
            outputLocation = "TopNships//" + "TopNships.txt";
            myWriter = new FileWriter(outputLocation, true);

            try {
                if (groupedList == null || groupedList.isEmpty()) {
                    myWriter.close();
                    File f1 = new File("PositionMessages//" + "PositionMessages.txt");
                    f1.delete();
                    return false;
                }
                for (Map.Entry<Integer, List<ShipMMSI>> map : groupedList) {
                    myWriter.write(String.valueOf(map.getValue()));
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
