package lapr.project.controller;

import lapr.project.model.ship.ShipAtrib;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.services.ListMMTDDD;
import lapr.project.tree.BST;

import java.util.List;

/**
 * The type List mmsi mov tddd controller.
 */
public class ListMMTDDDController {
    /**
     *
     * The List mmsi mov tddd.
     */
    ListMMTDDD listMMTDDD;

    /**
     * Instantiates a new List mmsi mov tddd controller.
     */
    public ListMMTDDDController() {
        listMMTDDD = new ListMMTDDD();
    }


    /**
     * List mmsi mov tddd list.
     *
     * @param shipList the ship list
     * @return the list
     */
    public List<ShipAtrib> listMmsiMovTDDD(BST<ShipMMSI> shipList) {
        return listMMTDDD.allShips(shipList);
    }

    /**
     * List desc trav dist list.
     *
     * @param list the list
     * @return the list
     */
    public List<ShipAtrib> listDescTravDist(List<ShipAtrib> list) {
        return listMMTDDD.listDescTravDist(list);
    }


    /**
     * List asce num mov list.
     *
     * @param list the list
     * @return the list
     */
    public List<ShipAtrib> listAsceNumMov(List<ShipAtrib> list) {
        return listMMTDDD.listAsceNumMov(list);
    }
}