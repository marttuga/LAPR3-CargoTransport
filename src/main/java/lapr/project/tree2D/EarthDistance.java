package lapr.project.tree2D;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class EarthDistance {
    public EarthDistance() {
    }

    public static double calculate(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6373;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return BigDecimal.valueOf(earthRadius * c).setScale(3, RoundingMode.HALF_EVEN).doubleValue();

    }

}
