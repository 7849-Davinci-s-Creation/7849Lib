package lib;

public final class OperatorControllerUtil {
    public static double handleDeadZone(double value, double deadZone) {
        return Math.abs(value) < deadZone ? 0 : value;
    }

    public static double applyCurve(double position, double torqueResistanceThreshold, double exponent) {
        // first part of equation is the same so extract to variable
        double part1 = (1 - torqueResistanceThreshold) * Math.pow(position, exponent);

        // apply piecewise logic
        if (position > 0) {
            return part1 + torqueResistanceThreshold;
        } else if (position < 0) {
            return part1 - torqueResistanceThreshold;
        }

        // else position is 0 so return 0
        return 0;
    }
}
