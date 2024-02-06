package lib;

import edu.wpi.first.math.util.Units;

/**
 * A utility class housing some useful algorithms for working with encoders.
 */
public final class Encoderutil {
    /** 
     * Takes a REV internal encoder position and converts it to feet.
     * @param encoderPosition rev internal encoder position.
     * @param gearRatio Drivetrain gear ratio.
     * @param wheelDiameter diameter of driveTrain wheels.
     * @return encoder position converted to feet.
     */
    public static double neoEncoderTicks2Feet(double encoderPosition, double gearRatio, double wheelDiameter) {
        // calculated 71.4 from
        // 1 wheel rotation = 5.95 gear rotations
        // 12 inches in one foot so 5.95 * 12 = 71.4
        double gearRotations2Feet = gearRatio * Constants.INCHES_IN_FEET;
        return encoderPosition * ((wheelDiameter*Math.PI)/gearRotations2Feet);
    }

    /**
     * Takes a REV internal encoder position and converts it to inches.
     * @param encoderPosition rev internal encoder position.
     * @param gearRatio Drivetrain gear ratio.
     * @param wheelDiameter diameter of driveTrain wheels.
     * @return encoder position converted to inches.
     */
    public static double neoEncoderTicks2Inches(double encoderPosition, double gearRatio, double wheelDiameter) {
        return encoderPosition * ((wheelDiameter*Math.PI)/gearRatio);
    }

    /**
     * Creates a linear distance conversion factor for a neo encoder based upon gear ratio and wheel radius
     * @param gearRatio Drivetrain gear ratio.
     * @param wheelRadiusInches The radius of the drivetrain wheels in inches.
     * @return A neo encoder linear distance conversion factor to be used as a conversion factor in neo encoders.
     * @implNote THIS IS IN METERS!
     */
    public static double linearDistanceConversionFactor(double gearRatio, double wheelRadiusInches) {
        return Units.inchesToMeters(1 / (gearRatio * 2 * Math.PI * Units.inchesToMeters(wheelRadiusInches) * 10));
    }
}
