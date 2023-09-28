package lapr.project.services;

import lapr.project.model.ship.Ship;
import lapr.project.model.ship.ShipMMSI;
import lapr.project.tree.BST;
import lapr.project.utils.DiferenceBetweenToDates;
import lapr.project.utils.DistanceBetweenTwoPointsCalculator;
import lapr.project.utils.ShipResumeSystem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ShipResume {


    public String getShipResume(int mMSI, BST<ShipMMSI> listTree) {
        List<ShipMMSI> list = new LinkedList<>();
        List<Map.Entry<Integer, ShipMMSI>> shipMMSIList;
        try {
            shipMMSIList = listTree.find(new ShipMMSI(mMSI)).getMapList();
        } catch (Exception e) {
            System.out.println("There is no ship with that MMSI");
            return null;
        }
        for (Map.Entry<Integer, ShipMMSI> s : shipMMSIList) {
            list.add(s.getValue());
        }

        String s = String.format("MMSI:%s%nIMO:%s%nCall Sign:%s%nVessel Name:%s%nStart Base Date Time:%s%nEnd Base Date Time:%s%nTotal Movements Time:%s%nTotal Number Of Movements:%s%nMax SOG:%s%nMean SOG:%s%nMax COG:%s%nMean COG:%s%nDeparture Latitude:%s%nDeparture Longitude:%s%nArrival Latitude:%s%nArrival Longitude:%s%nTravelled Distance:%s%nDelta Distance:%s%n ",
                list.get(0).getmMSI(), list.get(0).getiMO(), list.get(0).getCallSign(), list.get(0).getVesselName(), getBaseDateTimeInicial(list),
                getBaseDateTimeFinal(list), getTotalMovementTime(list), getTotalNumberOfMovements(list), getMaxSOG(list), getMeanSOG(list), getMaxCOG(list),
                getMeanCOG(list), getDepartureLatitude(list), getDepartureLongitude(list), getArrivalLatitude(list), getDepartureLongitude(list),
                getTravelDistance(list), getDeltaDistance(list));

        ShipResumeSystem.outPutResume(s, mMSI);
        return s;
    }


    public Date getBaseDateTimeInicial(List<ShipMMSI> list) {
        list.sort(Comparator.comparing(ShipMMSI::getBaseDateTime));

        return list.get(0).getBaseDateTime();
    }

    public Date getBaseDateTimeFinal(List<ShipMMSI> list) {
        list.sort((o1, o2) -> o2.getBaseDateTime().compareTo(o1.getBaseDateTime()));
        return list.get(0).getBaseDateTime();
    }

    public long getTotalMovementTime(List<ShipMMSI> shipList) {
        Date date1 = getBaseDateTimeInicial(shipList);
        Date date2 = getBaseDateTimeFinal(shipList);

        return DiferenceBetweenToDates.findDifference(date1, date2);
    }

    public int getTotalNumberOfMovements(List<ShipMMSI> list) {
        int numMovements = 0;
        list.sort(Comparator.comparing(Ship::getBaseDateTime));
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getlAT() != list.get(i + 1).getlAT() || list.get(i).getlON() != list.get(i + 1).getlON()) {
                numMovements++;
            }
        }
        return numMovements;
    }

    public double getMaxSOG(List<ShipMMSI> lShip) {
        List<Map.Entry<ShipMMSI, Double>> resultMapList = new LinkedList<>();
        for (ShipMMSI ship : lShip) {
            if (!containShip(ship.getmMSI(), resultMapList)) {
                Map<ShipMMSI, Double> shipMap = new HashMap<>();
                shipMap.put(ship, ship.getsOG());
                resultMapList.addAll(shipMap.entrySet());
            } else {
                if (resultMapList.get(0).getValue() < ship.getsOG()) {
                    resultMapList.get(0).setValue(ship.getsOG());
                }
            }
        }
        return resultMapList.get(0).getValue();
    }

    public double getMeanSOG(List<ShipMMSI> lShip) {
        List<Map.Entry<ShipMMSI, Double>> resultMapList = new LinkedList<>();
        double sog = 0;
        for (ShipMMSI ship : lShip) {
            if (!containShip(ship.getmMSI(), resultMapList)) {
                Map<ShipMMSI, Double> shipMap = new HashMap<>();
                sog = ship.getsOG();
                shipMap.put(ship, sog);
                resultMapList.addAll(shipMap.entrySet());
            } else {
                sog += ship.getsOG();
                resultMapList.get(0).setValue(sog);
            }
        }

        return BigDecimal.valueOf(sog / lShip.size()).setScale(3, RoundingMode.HALF_EVEN).doubleValue();

    }

    public double getMeanCOG(List<ShipMMSI> lShip) {
        List<Map.Entry<ShipMMSI, Double>> resultMapList = new LinkedList<>();
        double cog = 0;
        for (ShipMMSI ship : lShip) {
            if (!containShip(ship.getmMSI(), resultMapList)) {
                Map<ShipMMSI, Double> shipMap = new HashMap<>();
                cog = ship.getcOG();
                shipMap.put(ship, cog);
                resultMapList.addAll(shipMap.entrySet());
            } else {
                cog += ship.getcOG();
                resultMapList.get(0).setValue(cog);
            }
        }

        return BigDecimal.valueOf(cog / lShip.size()).setScale(3, RoundingMode.HALF_EVEN).doubleValue();

    }

    public double getMaxCOG(List<ShipMMSI> lShip) {
        List<Map.Entry<ShipMMSI, Double>> listMap = new LinkedList<>();
        for (ShipMMSI ship : lShip) {
            if (!containShip(ship.getmMSI(), listMap)) {
                Map<ShipMMSI, Double> shipMap = new HashMap<>();
                shipMap.put(ship, ship.getcOG());
                listMap.addAll(shipMap.entrySet());
            } else {
                if (listMap.get(0).getValue() < ship.getcOG()) {
                    listMap.get(0).setValue(ship.getcOG());
                }
            }
        }
        return listMap.get(0).getValue();
    }

    public boolean containShip(int mMSI, List<Map.Entry<ShipMMSI, Double>> map) {
        for (Map.Entry<ShipMMSI, Double> mapR : map) {
            if (mMSI == mapR.getKey().getmMSI()) {
                return true;
            }
        }
        return false;
    }

    public double getDepartureLatitude(List<ShipMMSI> list) {
        Date date = getBaseDateTimeInicial(list);
        for (ShipMMSI ship : list) {
            if (ship.getBaseDateTime().equals(date))
                return ship.getlAT();
        }
        return 0.0;
    }

    public double getDepartureLongitude(List<ShipMMSI> list) {
        Date date = getBaseDateTimeInicial(list);
        for (ShipMMSI ship : list) {
            if (ship.getBaseDateTime().equals(date))
                return ship.getlON();
        }
        return 0.0;
    }

    public double getArrivalLatitude(List<ShipMMSI> list) {
        Date date = getBaseDateTimeFinal(list);
        for (ShipMMSI ship : list) {
            if (ship.getBaseDateTime().equals(date))
                return ship.getlAT();
        }
        return 0.0;
    }

    public double getArrivalLongitude(List<ShipMMSI> list) {
        Date date = getBaseDateTimeFinal(list);
        for (ShipMMSI ship : list) {
            if (ship.getBaseDateTime().equals(date))
                return ship.getlON();
        }
        return 0.0;
    }

    public double getTravelDistance(List<ShipMMSI> shipList) {
        //(soma incremental da distância entre cada mensagem de posicionamento
        double incremental = 0;
        shipList.sort(Comparator.comparing(ShipMMSI::getBaseDateTime));
        for (int i = 0; i < shipList.size() - 1; i++) {

            incremental += DistanceBetweenTwoPointsCalculator.distance(shipList.get(i).getlAT(), shipList.get(i + 1).getlAT(), shipList.get(i).getlON(), shipList.get(i + 1).getlON());
        }

        return BigDecimal.valueOf(incremental).setScale(3, RoundingMode.HALF_EVEN).doubleValue();

    }

    public double getDeltaDistance(List<ShipMMSI> list) {
        //(distância linear entre as coordenadas do primeiro e último movimento)
        list.sort(Comparator.comparing(ShipMMSI::getBaseDateTime));
        Ship shipStart = list.get(0);
        list.sort((o1, o2) -> o2.getBaseDateTime().compareTo(o1.getBaseDateTime()));
        Ship shipArrive = list.get(0);

        return BigDecimal.valueOf(DistanceBetweenTwoPointsCalculator.distance(shipStart.getlAT(), shipArrive.getlAT(), shipStart.getlON(), shipArrive.getlON())).setScale(3, RoundingMode.HALF_EVEN).doubleValue();  //(distância linear entre as coordenadas do primeiro e último movimento)
    }
}



