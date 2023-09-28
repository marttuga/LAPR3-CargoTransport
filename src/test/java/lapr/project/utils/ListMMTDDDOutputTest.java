/*
package lapr.project.utils;

import lapr.project.model.ship.ShipAtrib;
import lapr.project.model.ship.ShipMMSI;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ListMMTDDDOutputTest {

    @Test
    void outPutList()  {

        List<ShipAtrib> list = new LinkedList<>();
        ShipAtrib a = new ShipAtrib(210950000, 24, 58.875, 58.869);
        ShipAtrib b = new ShipAtrib(212180000, 4, 54.076, 54.033);
        ShipAtrib c = new ShipAtrib(212351000, 0, 0.0, 0.0);
        ShipAtrib d = new ShipAtrib(228339600,  18, 85.261, 85.222);
        list.add(a);list.add(b);list.add(c);list.add(d);

        boolean result = ListMMTDDDOutput.outPutList(list);
        assertTrue(result);
        File f = new File("List_MMSI_Mov_TravDist_DelDist.txt");
        boolean aa = f.delete();
        assertTrue(aa);
        boolean bb =  ListMMTDDDOutput.outPutList(null);
        assertFalse(bb);
        File f1 = new File("List_MMSI_Movv_TravDist_DelDist.txt");
        boolean bc = f1.exists();
        assertFalse(bc);

        List<ShipAtrib>emptyList=new LinkedList<>();
        boolean cc =  ListMMTDDDOutput.outPutList(emptyList);
        assertFalse(cc);
        File f2 = new File("List_MMSIi_Mov_TravDist_DelDist.txt");
        boolean t=f2.exists();
        assertFalse(t);

        File f3 = new File("");
        boolean tt=f3.exists();
        assertFalse(tt);
    }

}*/
