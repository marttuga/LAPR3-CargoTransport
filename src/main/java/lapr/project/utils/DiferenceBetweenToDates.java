package lapr.project.utils;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DiferenceBetweenToDates {
    // Java program for the above approach


    private DiferenceBetweenToDates() {
    }

    // Function to print difference in
    // time start_date and end_date
    public static long findDifference(Date date1,
                                      Date date2) {
        long elapsedms = date1.getTime() - date2.getTime();
        long diff = TimeUnit.MINUTES.convert(elapsedms, TimeUnit.MILLISECONDS);
        return -diff;
    }

}


