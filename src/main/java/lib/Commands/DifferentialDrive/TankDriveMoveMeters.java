package lib.Commands.DifferentialDrive;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import lib.FunctionalInterfaces.DifferentialDrive;
import lib.FunctionalInterfaces.VoidMethod;

import java.util.function.Supplier;

/**
 * A Command that autonomously moves a DifferentialDrive robot forward X meters whilst accounting for drift.
 */
public class TankDriveMoveMeters extends Command {

    private final PIDController forwardPid;
    private final PIDController turnPid;
    private final VoidMethod zeroHeading;
    private final VoidMethod zeroEncoders;
    private final DifferentialDrive driving;
    private final Supplier<Double> getHeading;
    private final Supplier<Double> getEncoderDistance;
    private final double targetMeters;
    private final double turnError;

    /**
     * Creates an Autonomous MoveMeters command for a Differential Drive robot.
     * @implNote This Command is assuming the robot's encoder conversion method is in meters.
     * @param driving Method of driving the robot.
     * @param zeroEncoders Method of zeroing robot's encoders.
     * @param zeroHeading Method of zeroing robot's heading.
     * @param getHeading Method of retrieving the robot's current heading.
     * @param getEncoderDistance Method of retrieving the robot's encoder distance.
     * @param targetMeters Wanted meters of travel.
     * @param turnError Wanted error of heading to keep the robot straight.
     * @param forward_P Forward controller's P value.
     * @param forward_I Forward controller's I value.
     * @param forward_D Forward Controller's D value.
     * @param turn_P Turn Controller's P value.
     * @param turn_I Turn Controller's I value.
     * @param turn_D Turn Controller's D value.
     * @param requirements Subsystems the Command will enact upon (likely DriveTrain)
     */
    public TankDriveMoveMeters(DifferentialDrive driving,
                               VoidMethod zeroEncoders,
                               VoidMethod zeroHeading,
                               Supplier<Double> getHeading,
                               Supplier<Double> getEncoderDistance,
                               double targetMeters,
                               double turnError,
                               double forward_P,
                               double forward_I,
                               double forward_D,
                               double turn_P,
                               double turn_I,
                               double turn_D,
                               Subsystem... requirements) {

        this.forwardPid = new PIDController(forward_P, forward_I, forward_D);
        this.turnPid = new PIDController(turn_P, turn_I, turn_D);
        this.targetMeters = targetMeters;
        this.turnError = turnError;
        this.zeroHeading = zeroHeading;
        this.zeroEncoders = zeroEncoders;
        this.driving = driving;
        this.getHeading = getHeading;
        this.getEncoderDistance = getEncoderDistance;
        addRequirements(requirements);
    }

    @Override
    public void initialize() {
        zeroEncoders.run();
        zeroHeading.run();
    }

    @Override
    public void execute() {
        double goForward = forwardPid.calculate(getEncoderDistance.get(), targetMeters);
        double keepStraight = turnPid.calculate(getHeading.get(), turnError);

        driving.differentialDrive(keepStraight, goForward);
    }

    @Override
    public void end(boolean interuppted) {
       driving.differentialDrive(0,0);
    }

    @Override
    public boolean isFinished() {
        return getEncoderDistance.get() >= targetMeters;
    }
}
