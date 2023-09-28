package lapr.project.services;

import lapr.project.model.ship.Ship;
import lapr.project.model.ship.ShipAtrib;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.tree.BST;
import lapr.project.utils.ChainedShipAtribComparator;
import lapr.project.utils.ComparatorShipAtribByMMSI;
import lapr.project.utils.ComparatorShipAtribDescByTraveledDistance;
//import lapr.project.utils.PairOfShipsOutput;

import java.util.*;

public class PairOfShips{

    ShipResume shipResume = new ShipResume();

    /**
     * Pair ships list.
     *
     * @param tree BST<ShipMMSI>
     * @return the list of ShipAtrib
     */
    public List<ShipAtrib> pairShips(BST<ShipMMSI> tree){

        List <Map.Entry<Integer, ShipMMSI>> listMap = new LinkedList<>();

        List<ShipAtrib> newList = new LinkedList<>();
        List<ShipMMSI> list1 = new LinkedList<>();
        List<ShipMMSI> list2 = new LinkedList<>();

        for(ShipMMSI s: tree.inOrder() ){ //vai buscar a lista dos maps que estão nos nodes (onde a info está guardada)
            listMap.addAll(s.getMapList());
        }
        for(Map.Entry<Integer, ShipMMSI> s: listMap){
            list1.add(s.getValue()); //colocar a informação da lista de maps numa lista simples para facilitar
        }

        for(ShipMMSI s: list1){
            if(getTravelDistance(list1, s.getmMSI()) >= 10){
                list2.add(s); //lista de navios com a traveled distance superior a 10kms
            }
        }

        for (ShipMMSI s : list2) {
            newList.addAll(fillList(s, list2));//adiciona à lista, os dados que estão no map
        }

       /* System.out.println("Ship1 MMMSI          Ship1 MMMSI2                distOrig                        distDest                  Movs                        TravelDist                   Movs                      TravelDist   ");
        for (ShipAtrib s : sort(newList)) {
            System.out.printf("%s            %-28s%-28s     %-28s%-28s%-28s %-28s%-28s\n\n", s.getmMSI(), s.getmMSI1(), s.getDDistance1(),
                    s.getDDistance2(), s.getNumberOfMovements(), s.getTravelDistance(), s.getNumberOfMovements1(), s.getTravelDistance1());
        }*/

       // PairOfShipsOutput.outPut(sort(newList));

       return sort(newList);
    }


    /**
     * Fill list of ShipAtrib
     *
     * @param s    ShipMMSI
     * @param list List<ShipMMSI>
     * @return the list of ships with different MMSIs
     */
    public List<ShipAtrib> fillList(ShipMMSI s, List<ShipMMSI> list) {
        List<ShipAtrib> listShips = new LinkedList<>();
        for (ShipMMSI si : list) {
            if (si.getmMSI() != s.getmMSI()) {
                if(!verifyIfAlreadyHaveThePair(listShips, s.getmMSI(), si.getmMSI())) {
                    if(dDistance1(list, s.getmMSI()) < 5000 && dDistance2(list, si.getmMSI()) < 5000);
                    listShips.add(new ShipAtrib(s.getmMSI(), si.getmMSI(), dDistance1(list, s.getmMSI()), dDistance2(list, si.getmMSI())
                            , getNumberOfMovements(list, s.getmMSI()), getTravelDistance(list, s.getmMSI()),
                            getNumberOfMovements(list, si.getmMSI()), getTravelDistance(list, si.getmMSI())));
                }
            }
        }
        return listShips;
    }

    /**
     * Verify if already have the pair of Ships MMSIs
     *
     * @param list  List<ShipAtrib>
     * @param mmsi1 the mmsi ship1
     * @param mmsi2 the mmsi ship2
     * @return false if the pair doesn't exist yet
     */
    public boolean verifyIfAlreadyHaveThePair(List<ShipAtrib> list, int mmsi1, int mmsi2) {
        for (ShipAtrib shipAtrib : list) {
            if (shipAtrib.getmMSI() == mmsi1 && shipAtrib.getmMSI1() == mmsi2) {
                return true;
            }
        }
        return false;
    }


    /**
     * Delta distance
     *
     * @param list List<ShipMMSI>
     * @param mMSI1 the mmsi ship1
     * @return the delta distance
     */
    public double dDistance1(List<ShipMMSI> list, int mMSI1) {
        List<ShipMMSI> list1 = new LinkedList();

        for (ShipMMSI s : list) {
            if (s.getmMSI() == mMSI1) {
                list1.add(s);
         }
        }

        list1.sort(Comparator.comparing(Ship::getBaseDateTime));

        double d1 = shipResume.getDeltaDistance(list1);

        return d1;
    }


    /**
     * Delta distance
     *
     * @param list List<ShipMMSI>
     * @param mMSI2 the mmsi ship2
     * @return the delta distance
     */
    public double dDistance2(List<ShipMMSI> list, int mMSI2) {
        List<ShipMMSI> list1 = new LinkedList();

        for (ShipMMSI s : list) {
            if (s.getmMSI() == mMSI2) {
                list1.add(s);
            }
        }

        list1.sort(Comparator.comparing(Ship::getBaseDateTime));

        double d1 = shipResume.getDeltaDistance(list1);


        return d1;
    }


    /**
     * Gets number of movements of a given ship
     *
     * @param list List<ShipMMSI>
     * @param mMSI the mmsi
     * @return the number of movements
     */
    public int getNumberOfMovements(List<ShipMMSI> list, int mMSI) {
        List<ShipMMSI> lista = new LinkedList();
        for (ShipMMSI s : list) {
            if (s.getmMSI() == mMSI) {
                lista.add(s);
            }
        }
        return shipResume.getTotalNumberOfMovements(lista);
    }

    /**
     * Gets travel distance.
     *
     * @param list List<ShipMMSI>
     * @param mMSI the mmsi
     * @return the travel distance
     */
    public double getTravelDistance(List<ShipMMSI> list, int mMSI) {
        List<ShipMMSI> lista = new LinkedList();
        for (ShipMMSI s : list) {
            if (s.getmMSI() == mMSI) {
                lista.add(s);
            }
        }
        return shipResume.getTravelDistance(lista);
    }

    /**
     * List ordered by US107 requirements
     *
     * @param list List<ShipAtrib>
     * @return the list of ShipAtrib
     */
    public List<ShipAtrib> sort(List<ShipAtrib> list) {
        list.sort(new ChainedShipAtribComparator(new ComparatorShipAtribByMMSI(), new ComparatorShipAtribDescByTraveledDistance()));
        return list;
    }

}
