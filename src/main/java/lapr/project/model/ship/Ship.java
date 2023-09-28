package lapr.project.model.ship;

import lapr.project.utils.CountingAlgorithms;

import java.util.Date;
import java.util.Objects;

public class Ship {

    private int mMSI;
    //identificação do navio->210950000
    private Date baseDateTime;
    //31/12/2020 17:19==data / hora da mensagem AIS( contêm a informação posicional e de deslocamento de cada navio num determinado instante
    private double lAT;
    //42.97875==em graus: [-90; 90]
    private double lON;
    //-66.97001 [-180; 180]
    private double sOG;
    //,12.9==velocidade sobre o solo
    private double cOG;
    //   13.1== curso sobre o solo, direção relativa ao Norte absoluto (em graus: [0; 359])
    private int heading;
    //355== rumo do navio (em graus: [0; 359], 511 indica 'não disponível')
    private String vesselName;
    //nome do navio VARAMO
    private String iMO;
    //IMO9395044==número de identificação internacional único de 7 dígitos, que permanece inalterado após a
    //transferência do registo do navio para outro país
    private String callSign;
    //C4SQ2==indicativo único do navio
    private int vesselType;
    //70==tipo de navio, codificado numericamente
    private int length;
    //166==: comprimento do navio, em metros
    private int width;
    //25==largura do navio, em metros
    private double draft;
    //9.5==distância vertical entre a linha d'água e o fundo do casco do navio, em metros. Varia com a carga do navio e a densidade da água
    private int cargo;
    //NA==código do navio em reboque
    private String transcieverClass;
    //B== classe to transciever utilizado no envio dos dados
private String vehicleID;
    public Ship() {

    }

    public Ship(int mMSI, Date baseDateTime, double lAT, double lON, double sOG, double cOG, int heading, String vesselName, String iMO, String callSign, int vesselType, int length, int width, double draft, int cargo, String transcieverClass, String vehicleID) {
        if (baseDateTime == null && vesselName == null && iMO == null && callSign == null && transcieverClass == null) {
            throw new IllegalArgumentException("The attribute shouldn't be null");
        }
        if (CountingAlgorithms.numberLength(mMSI) != 9) {
            throw new IllegalArgumentException("The MMSI should have exactly 9 digits");
        }
        if (CountingAlgorithms.stringLength(iMO.replaceAll("[^0-9]", "")) != 7 || !iMO.startsWith("IMO")) {
            throw new IllegalArgumentException("The IMO should have exactly 7 digits");
        }

        this.mMSI = mMSI;
        this.baseDateTime = baseDateTime;
        this.lAT = lAT;
        this.lON = lON;
        this.sOG = sOG;
        this.cOG = cOG;
        this.heading = heading;
        this.vesselName = vesselName;
        this.iMO = iMO;
        this.callSign = callSign;
        this.vesselType = vesselType;
        this.length = length;
        this.width = width;
        this.draft = draft;
        this.cargo = cargo;
        this.transcieverClass = transcieverClass;
        this.vehicleID=vehicleID;
    }


    public Ship(Ship ship) {
        this.mMSI = ship.getmMSI();
        this.baseDateTime = ship.getBaseDateTime();
        this.lAT = ship.getlAT();
        this.lON = ship.getlON();
        this.sOG = ship.getsOG();
        this.cOG = ship.getcOG();
        this.heading = ship.getHeading();
        this.vesselName = ship.getVesselName();
        this.iMO = ship.getiMO();
        this.callSign = ship.getCallSign();
        this.vesselType = ship.getVesselType();
        this.length = ship.getLength();
        this.width = ship.getWidth();
        this.draft = ship.getDraft();
        this.cargo = ship.getCargo();
        this.transcieverClass = ship.getTranscieverClass();
        this.vehicleID=ship.getVehicleID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return mMSI == ship.mMSI && Double.compare(ship.lAT, lAT) == 0 && Double.compare(ship.lON, lON) == 0 && Double.compare(ship.sOG, sOG) == 0 && Double.compare(ship.cOG, cOG) == 0 && heading == ship.heading && vesselType == ship.vesselType && length == ship.length && width == ship.width && Double.compare(ship.draft, draft) == 0 && cargo == ship.cargo && Objects.equals(baseDateTime, ship.baseDateTime) && Objects.equals(vesselName, ship.vesselName) && Objects.equals(iMO, ship.iMO) && Objects.equals(callSign, ship.callSign) && Objects.equals(transcieverClass, ship.transcieverClass) && Objects.equals(vehicleID, ship.vehicleID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mMSI, baseDateTime, lAT, lON, sOG, cOG, heading, vesselName, iMO, callSign, vesselType, length, width, draft, cargo, transcieverClass, vehicleID);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "mMSI=" + mMSI +
                ", baseDateTime=" + baseDateTime +
                ", lAT=" + lAT +
                ", lON=" + lON +
                ", sOG=" + sOG +
                ", cOG=" + cOG +
                ", heading=" + heading +
                ", vesselName='" + vesselName + '\'' +
                ", iMO='" + iMO + '\'' +
                ", callSign='" + callSign + '\'' +
                ", vesselType=" + vesselType +
                ", length=" + length +
                ", width=" + width +
                ", draft=" + draft +
                ", cargo=" + cargo +
                ", transcieverClass='" + transcieverClass + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                '}';
    }

    public int getmMSI() {
        return mMSI;
    }

    public void setmMSI(int mMSI) {
        this.mMSI = mMSI;
    }

    public Date getBaseDateTime() {
        return baseDateTime;
    }

    public void setBaseDateTime(Date baseDateTime) {
        this.baseDateTime = baseDateTime;
    }

    public double getlAT() {
        return lAT;
    }

    public void setlAT(double lAT) {
        this.lAT = lAT;
    }

    public double getlON() {
        return lON;
    }

    public void setlON(double lON) {
        this.lON = lON;
    }

    public double getsOG() {
        return sOG;
    }

    public void setsOG(double sOG) {
        this.sOG = sOG;
    }

    public double getcOG() {
        return cOG;
    }

    public void setcOG(double cOG) {
        this.cOG = cOG;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getiMO() {
        return iMO;
    }

    public void setiMO(String iMO) {
        this.iMO = iMO;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public int getVesselType() {
        return vesselType;
    }

    public void setVesselType(int vesselType) {
        this.vesselType = vesselType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getDraft() {
        return draft;
    }

    public void setDraft(double draft) {
        this.draft = draft;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public String getTranscieverClass() {
        return transcieverClass;
    }

    public void setTranscieverClass(String transcieverClass) {
        this.transcieverClass = transcieverClass;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }
}
