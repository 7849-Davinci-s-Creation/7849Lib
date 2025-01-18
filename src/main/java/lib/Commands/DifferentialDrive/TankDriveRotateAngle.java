package lib.Commands.DifferentialDrive;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import lib.FunctionalInterfaces.DifferentialDrive;
import lib.FunctionalInterfaces.VoidMethod;

import java.util.function.Supplier;

/**
 * A command that autonomously turns a differential rive robot a given degrees.
 */
public class TankDriveRotateAngle extends Command {
    private final PIDController pid;
    private final VoidMethod zeroHeading;
    private final DifferentialDrive driving;
    private final Supplier<Double> getHeading;
    private final double angle;


    /**
     * Creates a new instance of command.
     * @param zeroHeading Method of resetting the Robot's heading.
     * @param driving Method of driving the Robot.
     * @param getHeading Method of retrieving the current heading of the Robot.
     * @param angle Wanted angle to move to.
     * @param P Command's Proportional term.
     * @param I Command's Integral term.
     * @param D Command's Derivative term.
     * @param requirements List of subsystems being used by this command. (likely just drivetrain).
     * @see Command
     */
    public TankDriveRotateAngle(VoidMethod zeroHeading, DifferentialDrive driving, Supplier<Double> getHeading, double angle, double P, double I, double D, Subsystem... requirements) {
        this.pid = new PIDController(P,I, D);
        this.angle = angle;
        this.zeroHeading = zeroHeading;
        this.driving = driving;
        this.getHeading = getHeading;
        addRequirements(requirements);
    }

    @Override
    public void initialize() {
        zeroHeading.run();
    }

    @Override
    public void execute() {
        driving.differentialDrive(pid.calculate(getHeading.get(), angle),0);
    }

    @Override
    public void end(boolean interrupted) {
        driving.differentialDrive(0,0);
    }

    @Override
    public boolean isFinished() {
        return getHeading.get() >= angle;
    }
}
