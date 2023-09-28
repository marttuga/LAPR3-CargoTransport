/*
package lapr.project.utils;

import lapr.project.model.ship.PositionalMessage;
import lapr.project.model.ship.ShipAtrib;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipSortedTemporallyOutputTest {

    @Test
    void outputShipSorted() throws ParseException {
        List<PositionalMessage> positionalMessages= new LinkedList<>();
        PositionalMessage pm = new PositionalMessage(212180000,70,11.7,119.9,new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 19:37"),24.34573,-85.12394);
        positionalMessages.add(pm);

        boolean a = ShipSortedTemporallyOutput.outputShipSorted(positionalMessages);
        assertTrue(a);
        File f = new File("PositionMessages//" + "PositionMessages.txt");
        boolean m = f.delete();
        assertTrue(m);
        boolean b =  ShipSortedTemporallyOutput.outputShipSorted(null);
        assertFalse(b);
        File f1 = new File("PositionMessages//" + "PositionMessages.txt");
        boolean n=f1.exists();
        assertFalse(n);
        List<PositionalMessage>emptyList=new LinkedList<>();
        boolean c =  ShipSortedTemporallyOutput.outputShipSorted(emptyList);
        assertFalse(c);
        File f2 = new File("PositionMessages//" + "PositionMessages.txt");
        boolean t=f2.exists();
        assertFalse(t);
        File f3 = new File("");
        boolean tt=f3.exists();
        assertFalse(tt);

    }
}*/
