/*
package lapr.project.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

*/
/**
 * The type Ship details output.
 *//*

public class ShipDetailsOutput {
    */
/**
     * Out put details boolean.
     *
     * @param details the details
     * @return the boolean
     *//*

    public static boolean outPutDetails(String details) {

        try {
            FileOutputStream f = new FileOutputStream("Ship_Details.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);
            try {
                if (details == null) {
                    return false;
                }
                o.writeObject(details);
            } finally {

                o.close();
                f.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
*/
