package lapr.project.controller;

import lapr.project.model.ship.ShipAtrib;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.services.PairOfShips;
import lapr.project.tree.BST;

import java.util.List;

public class PairOfShipsController {

    PairOfShips pairOfShips;

    public PairOfShipsController(){
        pairOfShips = new PairOfShips();
    }

    public List<ShipAtrib> pairShips(BST<ShipMMSI> tree){
        return pairOfShips.pairShips(tree);
    }

    public List<ShipAtrib> fillList(ShipMMSI s, List<ShipMMSI> list){
        return pairOfShips.fillList(s, list);
    }

    public double dDistance1 (List<ShipMMSI> list, int mmsi1) {
        return pairOfShips.dDistance1(list, mmsi1);
    }

    public double dDistance2(List<ShipMMSI> list, int mMSI2) {
        return pairOfShips.dDistance2(list, mMSI2);
    }

    public int getNumberOfMovements(List<ShipMMSI> list, int mMSI) {
        return pairOfShips.getNumberOfMovements(list, mMSI);
    }

    public List<ShipAtrib> sort(List<ShipAtrib> list) {
        return pairOfShips.sort(list);
    }

}

