package lapr.project.utils;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ColorMapOutput {

    private ColorMapOutput() {
    }

    public static boolean outPutColoredMap(String map) {
        try {
            FileOutputStream f = new FileOutputStream("coloredMap//coloredMap.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);
            try {
                if (map == null) {
                    return false;
                }
                o.writeObject(map);
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
