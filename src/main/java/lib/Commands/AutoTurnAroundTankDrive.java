package lib.Commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import lib.Drivetrains.DifferentialDrive;

public class AutoTurnAroundTankDrive extends Command {

    private final PIDController pid;
    private final DifferentialDrive drive;

   
    public AutoTurnAroundTankDrive(DifferentialDrive drive,double P, double I, double D ) {
        this.drive = drive;
        this.pid = new PIDController(P, I, D);
        addRequirements();
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void end(boolean interuppted) {
   
    }

    @Override
    public boolean isFinished() {
      return false;
    }


}
