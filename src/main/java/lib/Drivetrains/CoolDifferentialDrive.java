package lib.Drivetrains;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

/**
 * An object housing common functionalities of 7849 Differential Drive robots.
 */
public class CoolDifferentialDrive {
    private final MotorController leftLeader;
    private final MotorController rightLeader;

    /**
     * Creates an instance of the CoolDifferentialDrive Object.
     * @param leftLeader Leader of the left side of the drivetrain.
     * @param rightLeader Leader of the right side of the drivetrain.
     */
    public CoolDifferentialDrive(MotorController leftLeader, MotorController rightLeader) {
        this.leftLeader = leftLeader;
        this.rightLeader = rightLeader;
    }

    /**
     * Drives the robot Arcade Drive style. <br>
     * See <a href="https://xiaoxiae.github.io/Robotics-Simplified-Website/drivetrain-control/arcade-drive/">...</a> for more detail of how this method functions.
     * @param rotate Value to rotate the robot by.
     * @param drive Value to drive the robot by.
     */
    public void arcadeDrive(double rotate, double drive) {
        double maximum = Math.max(Math.abs(rotate), Math.abs(drive));
        double total = drive + rotate;
        double difference = drive - rotate;

        if (drive >= 0) {
            if (rotate >= 0) {
                leftLeader.set(maximum);
                rightLeader.set(difference);

            } else {
                leftLeader.set(total);
                rightLeader.set(maximum);
            }
        } else {
            if (rotate >= 0) {
                leftLeader.set(total);
                rightLeader.set(-maximum);
            } else {
                leftLeader.set(-maximum);
                rightLeader.set(difference);
            }
        }
    }

    /**
     * Applies a polynomial curve to the ramping speed of a robot's drivetrain.
     * @implNote This method is designed to be used within a loop with a varying position input.
     * @param position Current position of joystick or feed forward controller.
     * @param torqueResistanceThreshold Value to overcome carpet resistance with.
     * @param exponent Polynomial curve rate.
     * @return The position value curved.
     */
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
