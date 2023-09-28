package lapr.project.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlBridgeTest {


   ControlBridge controlBridge = new ControlBridge();

    @Test
    void choosePositionBow() {
        String a= controlBridge.choosePosition("bow");
        String b="Roll-on/roll-off (RORO) ships:\n" +
                "These are cargo ships designed to carry wheeled cargo that are driven on and off the ship on their own wheels or using a platform vehicle.\n" +
                "The vessels have either built-in or shore-based ramps that allow the cargo to be efficiently rolled on and off the vessel when in port.\n" +
                " Normally these ramps are made towards the stern of the ship to allow a better flow of the load in and out of the vessel, therefore the “control” bridge is usually found in the bow.\n" +
                "\n" +
                "The ro-ro passenger ferry with the greatest car-carrying capacity is the Ulysses.\n" +
                "It weighs 50,938 GT (‘Gross Tonnage’ = overall size of a ship) and is 209.02 m long and 31.84 m wide. It can carry 1342 cars and 4101 lane meters of cargo." ;System.out.println(a);
        assertEquals(a,b);
    }
    @Test
    void choosePositionMidship() {
        String a= controlBridge.choosePosition("midship");
        String b ="Navy Ships:\n" +
                "Guided Missile Cruisers \n" +
                "These ships usually carry Tomahawks, Harpoons, and other missiles. They are designed to provide defense against enemy aircraft.\n" +
                "They usually have a weight equal to 9,800 tons full load, length of 173 m, width equal to 16.8 m and draft of 10.2 m.";

        assertEquals(a,b);
    }
    @Test
    void choosePositionStern() {
        String a= controlBridge.choosePosition("stern");
        String b ="Container Ships. \n" +
                "These vessels are structured specifically to hold huge quantities of cargo, goods, and materials compacted in different types of \n" +
                "containers from one port to another. Therefore, the cargo space can be maximized with the control bridge in the stern of the ship.\n" +
                "\n" +
                "Bulk Carrier.\n" +
                "Bulk carriers are a type of ship that generally transport dry and loose cargo in bulk quantities and usually contains items like\n" +
                "food grains, coals and even cement. Consequently, having the control bridge in the stern is not a bad idea, since just like the container ship, a lot of space is needed.\n" +
                "\n" +
                "Both ships above are cargo ships and for the “Panamax” size category, the general characteristics are a tonnage of 52,500 DWT \n" +
                "(‘Deadweight tonnage’ = carrying capacity of a ship in tonnes), length of 289.56 m, width of 32.31 m,  height equals to 57.91 m, draft of \n" +
                "12.04 m and capacity of  5,000 TEU ( ‘twenty-foot equivalent unit’ = a standard measure used to calculate how many containers a ship can carry).";

        assertEquals(a,b);
    }
    @Test
    void choosePositionInvalid() {
        String a= controlBridge.choosePosition("b");
        String b ="\nThe positions for the control bridge can only be: bow, midship or stern.";

        assertEquals(a,b);
    }
}