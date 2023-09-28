package lapr.project.services;
import lapr.project.model.ship.PositionalMessage;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.tree.BST;
//import lapr.project.utils.ShipSortedTemporallyOutput;

import java.util.*;

/**
 * The type Ship sorted temporally.
 */
public class ShipSortedTemporally {

    public List<ShipMMSI> sortTemporally(int mMSI, BST<ShipMMSI> listTree) {
        List<ShipMMSI> list = new LinkedList<>();
        List<Map.Entry<Integer, ShipMMSI>> shipMMSIList = new LinkedList<>();
        for (ShipMMSI s : listTree.inOrder()) {
            shipMMSIList.addAll(s.getMapList());
        }

        for (Map.Entry<Integer, ShipMMSI> s : shipMMSIList) {
            if (s.getKey() == mMSI) {
                list.add(s.getValue());
            }
        }

        if (list.isEmpty()) {

            return null;
        }
        list.sort(Comparator.comparing(ShipMMSI::getBaseDateTime));
        return list;
    }

    public List<PositionalMessage> positionValues(List<ShipMMSI> list, Date startDatePeriod, Date endDatePeriod){
        List<PositionalMessage> positionsList = new LinkedList<>();
        for (ShipMMSI shipMMSI : list) {
            if (checkDate(startDatePeriod, endDatePeriod, shipMMSI.getBaseDateTime())) {
                PositionalMessage positionValue = new PositionalMessage(shipMMSI.getmMSI(), shipMMSI.getVesselType(), shipMMSI.getsOG(), shipMMSI.getcOG(), shipMMSI.getBaseDateTime(), shipMMSI.getlAT(), shipMMSI.getlON());
                positionsList.add(positionValue);
            }
        }
        if (positionsList.isEmpty()){
            return null;
        } else
            //ShipSortedTemporallyOutput.outputShipSorted(positionsList);
            return positionsList;
    }



    /**
     * Check date boolean.
     *
     * @param first    the first
     * @param last     the last
     * @param testDate the test date
     * @return the boolean
     */
    public boolean checkDate(Date first, Date last, Date testDate) {
        return first.before(testDate)
                && last.after(testDate);
    }

}
