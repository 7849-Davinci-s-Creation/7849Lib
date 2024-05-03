package lib;

/**
 * A utility class for working with Operator Controllers.
 */
public final class OperatorControllerUtil {
    /**
     * Creates a margin of error for a joystick axis.
     * @param value Current reading of joystick axis.
     * @param deadZone Margin of error for joystick axis.
     * @return 0 if within margin or error, the current joystick reading otherwise.
     */
    public static double handleDeadZone(double value, double deadZone) {
        return Math.abs(value) < deadZone ? 0 : value;
    }
}
