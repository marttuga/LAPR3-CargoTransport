package lapr.project.controller;
import lapr.project.model.ship.PositionalMessage;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.services.ShipSortedTemporally;
import lapr.project.tree.BST;
import java.util.Date;
import java.util.List;

public class ShipSortedTemporallyController {
    ShipSortedTemporally shipSortedTemporally;

    public ShipSortedTemporallyController() { shipSortedTemporally = new ShipSortedTemporally(); }

    public List<ShipMMSI> sortTemporally(int mMSI, BST<ShipMMSI> tree){
        return shipSortedTemporally.sortTemporally(mMSI, tree);
    }

    public List<PositionalMessage> positionValues(List<ShipMMSI> list, Date startDatePeriod, Date endDatePeriod) {
        return shipSortedTemporally.positionValues(list,startDatePeriod,endDatePeriod);
    }

}
