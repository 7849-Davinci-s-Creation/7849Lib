package lib.Drivetrains;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class DifferentialDrive {
    private final MotorController leftLeader;
    private final MotorController rightLeader;

    public DifferentialDrive(MotorController leftLeader, MotorController rightLeader) {
        this.leftLeader = leftLeader;
        this.rightLeader = rightLeader;
    }

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
