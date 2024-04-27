package lib;

public final class OperatorControllerUtil {
    public static double handleDeadZone(double value, double deadZone) {
        return Math.abs(value) < deadZone ? 0 : value;
    }
}
