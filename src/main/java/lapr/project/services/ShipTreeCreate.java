package lapr.project.services;

import lapr.project.model.ship.Ship;
import lapr.project.model.ship.ShipCallSign;
import lapr.project.model.ship.ShipIMO;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.tree.AVL;
import lapr.project.tree.BST;

import java.util.*;

public class ShipTreeCreate {

    /**
     * Variable representative of the BST for MMSI
     */
    public BST<ShipMMSI> treeMMSI;

    /**
     * Variable representative of the BST for IMO
     */
    public BST<ShipIMO> treeIMO;

    /**
     * Variable representative of the BST for Call Sign
     */
    public BST<ShipCallSign> treeCallSign;

    /**
     * Variable representative of List of Maps for ShipMMSI
     */
    public List<Map.Entry<Integer, ShipMMSI>> mapShipMMSI;
    /**
     * Variable representative of List of Maps for ShipIMO
     */
    public List<Map.Entry<String, ShipIMO>> mapShipIMO;
    /**
     * Variable representative of List of Maps for ShipCallSign
     */
    public List<Map.Entry<String, ShipCallSign>> mapShipCallSign;


    private void createShipMMSIMap(Ship e) {
        ShipMMSI ship = new ShipMMSI(e);
        Map<Integer, ShipMMSI> map = new HashMap<>();
        map.put(ship.getmMSI(), ship);

        if (!mapShipMMSI.isEmpty() && mapShipMMSI.get(0).getKey() != ship.getmMSI()) {
            mapShipMMSI.sort(Comparator.comparing(o -> o.getValue().getBaseDateTime()));
            treeMMSI.insert(new ShipMMSI(mapShipMMSI));
            mapShipMMSI = new LinkedList<>();
        }
        mapShipMMSI.addAll(map.entrySet());

    }

    private void createShipIMOMap(Ship e) {
        ShipIMO ship = new ShipIMO(e);
        Map<String, ShipIMO> map = new HashMap<>();
        map.put(ship.getiMO(), ship);

        if (!mapShipIMO.isEmpty() && !(mapShipIMO.get(0).getKey().equals(ship.getiMO()))) {
            mapShipIMO.sort(Comparator.comparing(o -> o.getValue().getBaseDateTime()));
            treeIMO.insert(new ShipIMO(mapShipIMO));
            mapShipIMO = new LinkedList<>();
        }
        mapShipIMO.addAll(map.entrySet());

    }

    private void createShipCallSignMap(Ship e) {
        ShipCallSign ship = new ShipCallSign(e);
        Map<String, ShipCallSign> map = new HashMap<>();
        map.put(ship.getCallSign(), ship);

        if (!mapShipCallSign.isEmpty() && !(mapShipCallSign.get(0).getKey().equals(ship.getCallSign()))) {
            mapShipCallSign.sort(Comparator.comparing(o -> o.getValue().getBaseDateTime()));
            treeCallSign.insert(new ShipCallSign(mapShipCallSign));
            mapShipCallSign = new LinkedList<>();
        }
        mapShipCallSign.addAll(map.entrySet());

    }

    public void creatShipTree(Ship e) {
        createShipMMSIMap(e);
        createShipIMOMap(e);
        createShipCallSignMap(e);
    }

    public ShipTreeCreate() {
        this.mapShipCallSign = new LinkedList<>();
        this.mapShipIMO = new LinkedList<>();
        this.mapShipMMSI = new LinkedList<>();
        this.treeMMSI = new AVL<>();
        this.treeIMO = new AVL<>();
        this.treeCallSign = new AVL<>();
    }

    public BST<ShipMMSI> getTreeMMSI() {
        return treeMMSI;
    }

    public BST<ShipIMO> getTreeIMO() {
        return treeIMO;
    }

    public BST<ShipCallSign> getTreeCallSign() {
        return treeCallSign;
    }


    public void resetTress() {
        this.treeMMSI = new AVL<>();
        this.treeIMO = new AVL<>();
        this.treeCallSign = new AVL<>();
        this.mapShipMMSI = new LinkedList<>();
        this.mapShipIMO = new LinkedList<>();
        this.mapShipCallSign = new LinkedList<>();
    }
}
