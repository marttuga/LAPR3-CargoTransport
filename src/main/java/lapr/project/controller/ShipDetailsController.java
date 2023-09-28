package lapr.project.controller;

import lapr.project.model.ship.ShipCallSign;
import lapr.project.model.ship.ShipIMO;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.services.ShipDetails;
import lapr.project.tree.BST;


/**
 * The type Ship details controller.
 */
public class ShipDetailsController {

    /**
     * The Ship details.
     */
    ShipDetails shipDetails;

    /**
     * Instantiates a new Ship details controller.
     */
    public ShipDetailsController() {
        shipDetails = new ShipDetails();
    }

    /**
     * Gets ship details mmsi.
     *
     * @param mMSI the m msi
     * @param tree the tree
     * @return the ship details mmsi
     */
    public String getShipDetailsMMSI(int mMSI, BST<ShipMMSI> tree) {
        return shipDetails.getShipDetailsMMSI(mMSI, tree);
    }

    /**
     * Gets ship details imo.
     *
     * @param iMO  the mo
     * @param tree the tree
     * @return the ship details imo
     */
    public String getShipDetailsIMO(String iMO, BST<ShipIMO> tree) {

        return shipDetails.getShipDetailsIMO(iMO, tree);
    }

    /**
     * Gets ship details call sign.
     *
     * @param callSign the call sign
     * @param tree     the tree
     * @return the ship details call sign
     */
    public String getShipDetailsCallSign(String callSign, BST<ShipCallSign> tree) {
        return shipDetails.getShipDetailsCallSign(callSign, tree);
    }
}

