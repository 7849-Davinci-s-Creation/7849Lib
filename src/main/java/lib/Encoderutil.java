package lib;

/**
 * A utility class housing some useful algorithms for working with encoders.
 */
public final class Encoderutil {
    /** 
     * Takes a REV internal encoder position and converts it to feet.
     * @param encoderPosition rev internal encoder position.
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
     * @return encoder position converted to feet.
     */
    public static double neoEncoderTicks2Inches(double encoderPosition, double gearRatio, double wheelDiameter) {
        return encoderPosition * ((wheelDiameter*Math.PI)/gearRatio);
    }
}
