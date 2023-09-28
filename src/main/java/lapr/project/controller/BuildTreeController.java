package lapr.project.controller;

import lapr.project.model.port.Port;
import lapr.project.model.ship.Ship;
import lapr.project.model.ship.ShipCallSign;
import lapr.project.model.ship.ShipIMO;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.services.Port2DTreeCreate;
import lapr.project.services.ShipTreeCreate;
import lapr.project.tree.BST;
import lapr.project.tree2D.KdTree;
import lapr.project.tree2D.Node;

import java.util.Date;
import java.util.List;

public class BuildTreeController {

    private static BuildTreeController instance = null;
    ShipTreeCreate shipTreeCreate;
    Port2DTreeCreate port2DTreeCreate;

    private BuildTreeController() {
        shipTreeCreate = new ShipTreeCreate();
        port2DTreeCreate = new Port2DTreeCreate();
    }

    public void creatShipTree(int mMSI, Date baseDateTime, double lAT, double lON, double sOG, double cOG, int heading, String vesselName, String iMO, String callSign, int vesselType, int length, int width, double draft, int cargo, String transcieverClass, String vehicleID) {
        Ship ship = new Ship(mMSI, baseDateTime, lAT, lON, sOG, cOG, heading, vesselName, iMO, callSign, vesselType, length, width, draft, cargo, transcieverClass,vehicleID);
        shipTreeCreate.creatShipTree(ship);
    }

    public BST<ShipMMSI> getBSTByShipMMSI() {
        return shipTreeCreate.getTreeMMSI();
    }

    public BST<ShipIMO> getBSTByShipIMO() {
        return shipTreeCreate.getTreeIMO();
    }

    public BST<ShipCallSign> getBSTByCallSign() {
        return shipTreeCreate.getTreeCallSign();
    }

    public void resetShipTrees() {
        shipTreeCreate.resetTress();
    }

    public void fillPortNodeList(String continent, String country, int code, String portCity, double lat, double lon) {
        Port port = new Port(continent, country, code, portCity, lat, lon);
        port2DTreeCreate.fillList(port);
    }

    public void build2DPortTree() {
        port2DTreeCreate.build2DPortTree();
    }

    public List<Node<Port>> getPortNodeList() {
        return port2DTreeCreate.getNodeList();
    }

    public KdTree<Port> getPort2dTree(){
        return port2DTreeCreate.getPort2dTree();
    }

    public void reset2DPortTree() {
        port2DTreeCreate.reset2DPortTree();
    }

    public static BuildTreeController getInstance() {
        if (instance == null) {
            instance = new BuildTreeController();
        }
        return instance;
    }

}
