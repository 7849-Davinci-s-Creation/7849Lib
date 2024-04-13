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
}
