package lapr.project.controller;

import lapr.project.model.ship.ShipMMSI;
import lapr.project.services.MostTravelledDistance;
import lapr.project.tree.BST;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MostTravelledDistanceController {
    MostTravelledDistance mostTravelledDistance;

    public MostTravelledDistanceController(){ mostTravelledDistance= new MostTravelledDistance();}

    public List<Map.Entry<Integer, List<ShipMMSI>>> getTopNShips(BST<ShipMMSI> listTree, Date startDate, Date endDate, int n){
        return mostTravelledDistance.getTopNShips(listTree,startDate,endDate,n);
    }
    public boolean containShip(List<ShipMMSI> list, int mMSI) {
        return mostTravelledDistance.containShip(list,mMSI);
    }

    public List<ShipMMSI> sameMMSIList(List<ShipMMSI> list, int mMSI) {
        return mostTravelledDistance.sameMMSIList(list,mMSI);
    }
}
