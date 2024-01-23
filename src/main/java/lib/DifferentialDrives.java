package lib;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * A utility class housing all of 7849's different differential drive algorithms.
 */
public class DifferentialDrives {
    /**
     * Utilizes linear interpolation to create a arcade drive differential drive type.
     *
     * @param drive       Wanted forward and backwards movement.
     * @param rotate      Wanted turning movement.
     * @param leftMotors  Motors on left side of robot.
     * @param rightMotors Motors on right side of robot.
     */
    public static void arcadeDrive(double drive, double rotate, MotorControllerGroup leftMotors, MotorControllerGroup rightMotors) {
        /* Think of a X,Y plane (What you would use to create a graph).
         * We can actually split each section of the graph into quadrants.
         * -----------------
         * |      |        |
         * |  2   |   1    |    We do that like so !
         * |      |        |    So if I have a positive pair of numbers (we call those coordinates) like (1,3) for example,
         * |------|--------|    the point we would place would be in quadrant 1 and so forth depending on the points you put on the graph.
         * |   3  |   4    |
         * |      |        |
         * -----------------
         */

        // variables for determining the quadrants
        double maximum = Math.max(Math.abs(drive), Math.abs(rotate));
        double total = drive + rotate;
        double difference = drive - rotate;

        // set speed according to the quadrant that the values are in
        if (drive >= 0) {
            if (rotate >= 0) { // quadrant 1
                leftMotors.set(maximum);
                rightMotors.set(difference);
            } else { // quadrant 2
                leftMotors.set(total);
                rightMotors.set(maximum);
            }
        } else {
            if (rotate >= 0) { // quadrant 4
                leftMotors.set(total);
                rightMotors.set(-maximum);
            } else { // quadrant 3
                leftMotors.set(-maximum);
                rightMotors.set(difference);
            }
        }
    }
}
