package lapr.project.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class ShipResumeControllerTest {

    ReadFilesController readFilesController;
    ShipResumeController shipResume;

    @BeforeEach
    void setUp() {
        readFilesController = new ReadFilesController();
        shipResume = new ShipResumeController();
    }

    @AfterEach
    void tearDown() {
        BuildTreeController.getInstance().resetShipTrees();
    }

    @Test
    void getShipResume() throws ParseException {

        readFilesController.load();
        if (!ReadFilesController.isUseBigFiles()) {
            String a = shipResume.getShipResume(228339600, BuildTreeController.getInstance().getBSTByShipMMSI());
            String b = String.format("MMSI:%s%nIMO:%s%nCall Sign:%s%nVessel Name:%s%nStart Base Date Time:%s%nEnd Base Date Time:%s%nTotal Movements Time:%s%nTotal Number Of Movements:%s%nMax SOG:%s%nMean SOG:%s%nMax COG:%s%nMean COG:%s%nDeparture Latitude:%s%nDeparture Longitude:%s%nArrival Latitude:%s%nArrival Longitude:%s%nTravelled Distance:%s%nDelta Distance:%s%n ", 228339600, "IMO9450648", "FLSU", "CMA CGM ALMAVIVA", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 00:00"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 3:56"), 236, 18, 12.0, 11.732, 131.1, 129.037, 28.37458, -88.88584, 27.87869, -88.88584, 85.261, 85.222);
            assertEquals(a, b);

            String c = shipResume.getShipResume(212351000, BuildTreeController.getInstance().getBSTByShipMMSI());
            String d = String.format("MMSI:%s%nIMO:%s%nCall Sign:%s%nVessel Name:%s%nStart Base Date Time:%s%nEnd Base Date Time:%s%nTotal Movements Time:%s%nTotal Number Of Movements:%s%nMax SOG:%s%nMean SOG:%s%nMax COG:%s%nMean COG:%s%nDeparture Latitude:%s%nDeparture Longitude:%s%nArrival Latitude:%s%nArrival Longitude:%s%nTravelled Distance:%s%nDelta Distance:%s%n ", 212351000, "IMO9305685", "5BZP3", "HYUNDAI SINGAPORE", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 23:03"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 23:03"), 0, 0, 3.5, 3.5, -61.6, -61.6, 55.09307, -167.63625, 55.09307, -167.63625, 0.0, 0.0);
            assertEquals(c, d);
        } else {
            String a = shipResume.getShipResume(441188000, BuildTreeController.getInstance().getBSTByShipMMSI());
            String b = String.format("MMSI:%s%nIMO:%s%nCall Sign:%s%nVessel Name:%s%nStart Base Date Time:%s%nEnd Base Date Time:%s%nTotal Movements Time:%s%nTotal Number Of Movements:%s%nMax SOG:%s%nMean SOG:%s%nMax COG:%s%nMean COG:%s%nDeparture Latitude:%s%nDeparture Longitude:%s%nArrival Latitude:%s%nArrival Longitude:%s%nTravelled Distance:%s%nDelta Distance:%s%n ", 441188000, "IMO9651113", "D8GS", "GLOVIS CHAMPION", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 00:00"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 22:20"), 1340, 624, 18.5, 13.328, 201.4, -77.909, 26.67097, -79.4351, 30.94004, -79.4351, 557.372, 503.309);
            assertEquals(a, b);

            String c = shipResume.getShipResume(366904930, BuildTreeController.getInstance().getBSTByShipMMSI());
            String d = String.format("MMSI:%s%nIMO:%s%nCall Sign:%s%nVessel Name:%s%nStart Base Date Time:%s%nEnd Base Date Time:%s%nTotal Movements Time:%s%nTotal Number Of Movements:%s%nMax SOG:%s%nMean SOG:%s%nMax COG:%s%nMean COG:%s%nDeparture Latitude:%s%nDeparture Longitude:%s%nArrival Latitude:%s%nArrival Longitude:%s%nTravelled Distance:%s%nDelta Distance:%s%n ", 366904930, "IMO5148417", "WL3972", "HERBERT C JACKSON", new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 00:00"), new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("31/12/2020 22:59"), 1379, 1202, 12.8, 11.484, 50.1, -50.565, 42.5556, -82.58517, 46.37353, -82.58517, 491.848, 443.804);
            assertEquals(c, d);


        }
    }
}