
package lapr.project.services;

import lapr.project.model.port.Port;
import lapr.project.model.ship.ShipCallSign;
import lapr.project.tree.BST;
import lapr.project.tree2D.KdTree;

import java.util.*;

/**
 * The type Find closest port.
 */
public class FindClosestPort {
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
        return getNearestPort(ports, treeCallSign.find(new ShipCallSign(shipCallSign)).getMapList(), shipCallSign, baseDateTime);
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
        for (Map.Entry<String, ShipCallSign> l : list) {
            if (l.getKey().equals(shipCallSign)) {
                if (l.getValue().getBaseDateTime().equals(baseDateTime)) {
                    return ports.findNearestNeighbour(l.getValue().getlAT(), l.getValue().getlON());
                }
            }
        }
        return null;
    }
}
