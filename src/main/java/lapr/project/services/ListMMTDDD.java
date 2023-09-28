package lapr.project.services;

import lapr.project.model.ship.ShipAtrib;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.tree.BST;
//import lapr.project.utils.ListMMTDDDOutput;

import java.util.*;

/**
 * The type List mmsi mov tddd.
 */
public class ListMMTDDD {
    /**
     * The Ship resume.
     */
    ShipResume shipResume = new ShipResume();

    /**
     * All ships list.
     * Receives tree with all ships, filters each ship and creates an object
     * of the type ShipMMTDDD for each ship and then creates a new list with
     * all objects of this type
     *
     * @param shipList the ship list
     * @return the list
     */
    public List<ShipAtrib> allShips(BST<ShipMMSI> shipList) {
        List<ShipMMSI> list = new LinkedList<>();
        List<Map.Entry<Integer, ShipMMSI>> shipMMSIList = new LinkedList<>();
        for (ShipMMSI s : shipList.inOrder()) {
            shipMMSIList.addAll(s.getMapList());
        }

        for (Map.Entry<Integer, ShipMMSI> s : shipMMSIList) {
            list.add(s.getValue());
        }

        List<ShipAtrib> finalList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!containShip(finalList, list.get(i).getmMSI())) {
                finalList.add(shipMmsiMovTDDD(sameMMSIList(list, list.get(i).getmMSI())));
            }
        }

        return finalList;
    }

    /**
     * Ship mmsi mov tddd ship mmtddd.
     *
     * @param list the list
     * @return the ship mmtddd
     */
    public ShipAtrib shipMmsiMovTDDD(List<ShipMMSI> list) {

        return new ShipAtrib(list.get(0).getmMSI(), shipResume.getTotalNumberOfMovements(list),
                shipResume.getTravelDistance(list), shipResume.getDeltaDistance(list));


    }

    /**
     * Same mmsi list list.
     *
     * @param list the list
     * @param mMSI the m msi
     * @return the list
     */
    public List<ShipMMSI> sameMMSIList(List<ShipMMSI> list, int mMSI) {
        List<ShipMMSI> listt = new LinkedList<>();
        for (ShipMMSI shipMMSI : list) {
            if (shipMMSI.getmMSI() == mMSI) {
                listt.add(shipMMSI);
            }
        }
        return listt;
    }

    /**
     * Contain ship boolean.
     *
     * @param list the list
     * @param mMSI the m msi
     * @return the boolean
     */
    public boolean containShip(List<ShipAtrib> list, int mMSI) {
        for (ShipAtrib ship : list) {
            if (ship.getmMSI() == mMSI) {
                return true;
            }
        }
        return false;
    }

    /**
     * List desc trav dist list.
     *
     * @param list the list
     * @return the list
     */
    public List<ShipAtrib> listDescTravDist(List<ShipAtrib> list) {
        list.sort(Comparator.comparing(ShipAtrib::getTravelDistance).reversed());
      //  System.out.println(list);
        //ListMMTDDDOutput.outPutList(list);
        return list;
    }

    /**
     * List asce  num movements list.
     *
     * @param list the list
     * @return the list
     */
    public List<ShipAtrib> listAsceNumMov(List<ShipAtrib> list) {
        list.sort(Comparator.comparing(ShipAtrib::getNumberOfMovements));

        //ListMMTDDDOutput.outPutList(list);

        return list;
    }
}