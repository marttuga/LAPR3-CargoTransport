package lapr.project.services;

import lapr.project.model.ship.Ship;
import lapr.project.model.ship.ShipMMSI;

import lapr.project.tree.BST;
import lapr.project.utils.TopNShipsOutput;

import java.util.*;
import java.util.stream.Collectors;

public class MostTravelledDistance {
    ShipResume shipResume = new ShipResume();

    public List<Map.Entry<Integer, List<ShipMMSI>>> getTopNShips(BST<ShipMMSI> listTree, Date startDate, Date endDate, int n) {
        List<ShipMMSI> list = new LinkedList<>();
        List<Map.Entry<Integer, ShipMMSI>> shipMMSIList = new LinkedList<>();

        for (ShipMMSI s : listTree.inOrder()) {
            shipMMSIList.addAll(s.getMapList());
        }

        for (Map.Entry<Integer, ShipMMSI> s : shipMMSIList) {
            if (checkDate(startDate, endDate, s.getValue().getBaseDateTime())) {
                list.add(s.getValue());
            }
        }

        List<ShipMMSI> shipList = new LinkedList<>();
        for (ShipMMSI s : list) {
            if (!containShip(shipList, s.getmMSI())) {
                Ship ship = new Ship(s.getmMSI(), s.getBaseDateTime(), s.getlAT(), s.getlON(), shipResume.getMeanSOG(sameMMSIList(list, s.getmMSI())), s.getcOG(), s.getHeading(), s.getVesselName(), s.getiMO(), s.getCallSign(), s.getVesselType(), s.getLength(), s.getWidth(), s.getDraft(), s.getCargo(), s.getTranscieverClass(), s.getVehicleID());
                ShipMMSI shipMMSI = new ShipMMSI(ship, shipResume.getTravelDistance(sameMMSIList(list, s.getmMSI())));
                shipList.add(shipMMSI);
                shipList.sort(Comparator.comparing(ShipMMSI::getTravelDistance).reversed());
            }
        }
        Map<Integer, List<ShipMMSI>> groupedMap = shipList.stream().collect(Collectors.groupingBy(ShipMMSI::getVesselType));

        List<Map.Entry<Integer, List<ShipMMSI>>> groupedList = new LinkedList<>(groupedMap.entrySet());

        for (Map.Entry<Integer, List<ShipMMSI>> l : groupedList) {
            while (l.getValue().size() > n) {
                l.getValue().remove(groupedList.size() - 1);
            }

        }

        TopNShipsOutput.outputTopNShips(groupedList);
        return groupedList;
    }

    public boolean containShip(List<ShipMMSI> list, int mMSI) {
        for (ShipMMSI ship : list) {
            if (ship.getmMSI() == mMSI) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDate(Date first, Date last, Date testDate) {
        return first.before(testDate)
                && last.after(testDate);
    }

    public List<ShipMMSI> sameMMSIList(List<ShipMMSI> list, int mMSI) {
        List<ShipMMSI> listt = new LinkedList<>();
        for (ShipMMSI shipMMSI : list) {
            if (shipMMSI.getmMSI() == mMSI) {
                listt.add(shipMMSI);
            }
        }
        return listt;
    }

}


