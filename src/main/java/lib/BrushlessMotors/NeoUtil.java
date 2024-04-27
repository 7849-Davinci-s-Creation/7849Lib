package lib.BrushlessMotors;

import edu.wpi.first.math.util.Units;

/**
 * A utility class for NEO brushless motors.
 */
public final class NeoUtil {
    /**
     * Generates a linear conversion factor of meters.
     * @param gearRatio Gear Ratio of DriveTrain.
     * @param wheelRadiusInches Radius of DriveTrain wheels.
     * @return Linear conversion factor calculated based upon the passed gear ratio and wheel radius.
     */
    public static double linearConversionFactorOfMeters(double gearRatio, double wheelRadiusInches) {
        return Units.inchesToMeters(
                1 / (gearRatio * 2 * Math.PI * Units.inchesToMeters(wheelRadiusInches)) * 10);
    }
}
