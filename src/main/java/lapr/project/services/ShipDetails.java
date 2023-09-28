package lapr.project.services;

import lapr.project.model.ship.ShipCallSign;
import lapr.project.model.ship.ShipIMO;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.tree.BST;
//import lapr.project.utils.ShipDetailsOutput;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The type Ship details.
 */
public class ShipDetails {

    /**
     *
     * Gets ship details with mmsi code.
     *
     * @param mMSI     the m msi
     * @param listMMSI the list mmsi
     * @return the ship details mmsi
     */
    public String getShipDetailsMMSI(int mMSI, BST<ShipMMSI> listMMSI) {
        List<ShipMMSI> list = new LinkedList<>();
        List<Map.Entry<Integer, ShipMMSI>> shipMMSIList = new LinkedList<>();
        for (ShipMMSI s : listMMSI.inOrder()) {
            shipMMSIList.addAll(s.getMapList());
        }

        for (Map.Entry<Integer, ShipMMSI> s : shipMMSIList) {
            if (s.getKey() == mMSI) {
                list.add(s.getValue());
            }
        }

        if (list.isEmpty()) {
            return null;
        }


        String details = "\nMMSI: " + list.get(0).getmMSI() +
                " \nIMO: " + list.get(0).getiMO() +
                " \nCALL SIGN: " + list.get(0).getCallSign() +
                "\nVESSEL NAME: " + list.get(0).getVesselName() +
                " \nVESSEL TYPE: " + list.get(0).getVesselType() +
                " \nLENGHT: " + list.get(0).getLength() +
                " \nWIDTH: " + list.get(0).getWidth() +
                " \nDRAFT: " + list.get(0).getDraft() +
                " \nCARGO:" + list.get(0).getCargo() +
                " \nTRANSCEIVER CLASS: " + list.get(0).getTranscieverClass() +
                "\n--//--";

        //ShipDetailsOutput.outPutDetails(details);
        return details;
    }

    /**
     * Gets ship details with imo code.
     *
     * @param iMO     the mo
     * @param listIMO the list imo
     * @return the ship details imo
     */
    public String getShipDetailsIMO(String iMO, BST<ShipIMO> listIMO) {

        List<ShipIMO> list = new LinkedList<>();
        List<Map.Entry<String, ShipIMO>> shipIMOList = new LinkedList<>();
        for (ShipIMO s : listIMO.inOrder()) {
            shipIMOList.addAll(s.getMapList());
        }

        for (Map.Entry<String, ShipIMO> s : shipIMOList) {
            if (s.getKey().equals(iMO)) {
                list.add(s.getValue());
            }
        }

        if (list.isEmpty()) {
            return null;
        }

        String details = "\nMMSI: " + list.get(0).getmMSI() +
                " \nIMO: " + list.get(0).getiMO() +
                " \nCALL SIGN: " + list.get(0).getCallSign() +
                "\nVESSEL NAME: " + list.get(0).getVesselName() +
                " \nVESSEL TYPE: " + list.get(0).getVesselType() +
                " \nLENGHT: " + list.get(0).getLength() +
                " \nWIDTH: " + list.get(0).getWidth() +
                " \nDRAFT: " + list.get(0).getDraft() +
                " \nCARGO:" + list.get(0).getCargo() +
                " \nTRANSCEIVER CLASS: " + list.get(0).getTranscieverClass() +
                "\n--//--";

        //ShipDetailsOutput.outPutDetails(details);
        return details;
    }

    /**
     * Gets ship details with call sign.
     *
     * @param callSign     the call sign
     * @param listCallSign the list call sign
     * @return the ship details call sign
     */
    public String getShipDetailsCallSign(String callSign, BST<ShipCallSign> listCallSign) {

        List<ShipCallSign> list = new LinkedList<>();
        List<Map.Entry<String, ShipCallSign>> shipCallSignList = new LinkedList<>();
        for (ShipCallSign s : listCallSign.inOrder()) {
            shipCallSignList.addAll(s.getMapList());
        }

        for (Map.Entry<String, ShipCallSign> s : shipCallSignList) {
            if (s.getKey().equals(callSign)) {
                list.add(s.getValue());
            }
        }

        if (list.isEmpty()) {
       //     System.out.println("There is no ship with that Call Sign");
            return null;
        }


        String details = "\nMMSI: " + list.get(0).getmMSI() +
                " \nIMO: " + list.get(0).getiMO() +
                " \nCALL SIGN: " + list.get(0).getCallSign() +
                "\nVESSEL NAME: " + list.get(0).getVesselName() +
                " \nVESSEL TYPE: " + list.get(0).getVesselType() +
                " \nLENGHT: " + list.get(0).getLength() +
                " \nWIDTH: " + list.get(0).getWidth() +
                " \nDRAFT: " + list.get(0).getDraft() +
                " \nCARGO:" + list.get(0).getCargo() +
                " \nTRANSCEIVER CLASS: " + list.get(0).getTranscieverClass() +
                "\n--//--";

        //ShipDetailsOutput.outPutDetails(details);
        return details;
    }
}

