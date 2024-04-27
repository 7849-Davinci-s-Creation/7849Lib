package lib.Commands;

import java.util.function.Supplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import lib.FunctionalInterfaces.ArcadeDrive;
import lib.FunctionalInterfaces.VoidMethod;

public class AutoTurnAroundTankDrive extends Command {

  private final PIDController pid;
  private final VoidMethod zeroHeading;
  private final ArcadeDrive driving;
  private final Supplier<Double> getHeading;

  public AutoTurnAroundTankDrive(VoidMethod zeroHeading, ArcadeDrive driving, Supplier<Double> getHeading, double P,
      double I, double D, Subsystem... requirements) {
    this.pid = new PIDController(P, I, D);
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
    driving.arcadeDrive(pid.calculate(getHeading.get(), 180), 0);

  }

  @Override
  public void end(boolean interuppted) {
    driving.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return getHeading.get() >= 180;
  }

}
