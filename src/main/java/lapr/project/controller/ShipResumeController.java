package lapr.project.controller;


import lapr.project.model.ship.ShipMMSI;
import lapr.project.services.ShipResume;
import lapr.project.tree.BST;

public class ShipResumeController {

    ShipResume shipResume;

    public ShipResumeController() {
        shipResume = new ShipResume();
    }

    public String getShipResume(int mMSI, BST<ShipMMSI> tree) {
        return shipResume.getShipResume(mMSI, tree);
    }
}