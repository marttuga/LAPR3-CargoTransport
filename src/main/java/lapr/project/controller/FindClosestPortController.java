package lapr.project.controller;

import lapr.project.model.port.Port;
import lapr.project.model.ship.ShipCallSign;
import lapr.project.services.FindClosestPort;
import lapr.project.tree.BST;
import lapr.project.tree2D.KdTree;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The type Find closest port controller.
 */
public class FindClosestPortController {

    /**
     * The Find closest port.
     */
    FindClosestPort findClosestPort;

    /**
     * Instantiates a new Find closest port controller.
     */
    public FindClosestPortController() {
       findClosestPort = new FindClosestPort();
    }

    /**
     * Find port close port.
     *
     * @param ports        the ports
     * @param shipCallSign the ship call sign
     * @param treeCallSign the tree call sign
     * @param baseDateTime the base date time
     * @return the port
     */
    public Port findPortClose(KdTree<Port> ports, String shipCallSign, BST<ShipCallSign> treeCallSign, Date baseDateTime) {
        return findClosestPort.findPortClose(ports,shipCallSign,treeCallSign,baseDateTime);
    }

    /**
     * Gets nearest port.
     *
     * @param ports        the ports
     * @param list         the list
     * @param shipCallSign the ship call sign
     * @param baseDateTime the base date time
     * @return the nearest port
     */
    public Port getNearestPort(KdTree<Port> ports, List<Map.Entry<String, ShipCallSign>> list, String shipCallSign, Date baseDateTime) {
        return findClosestPort.getNearestPort(ports,list,shipCallSign,baseDateTime);
    }
}
