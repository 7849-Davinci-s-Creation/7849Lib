package lib.BrushlessMotors;

import edu.wpi.first.math.util.Units;

public final class NeoUtil {
    public static double linearConversionFactorOfMeters(double gearRatio, double wheelRadiusInches) {
        return Units.inchesToMeters(
                1 / (gearRatio * 2 * Math.PI * Units.inchesToMeters(wheelRadiusInches)) * 10);
    }
}
