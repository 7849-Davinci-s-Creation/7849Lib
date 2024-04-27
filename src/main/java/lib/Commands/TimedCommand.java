package lib.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;

/**
 * An instance of a WPILib Command that is executed based on a given time limit.
 * @see Command
 */
public abstract class TimedCommand extends Command {
    private final double seconds;

    private double startingTime;

    /**
     * Creates an instance of a Timed WPILib Command.
     * @param seconds Number of seconds Command should execute.
     * @param requirements List of Subsystems command is executing upon.
     */
    public TimedCommand(double seconds, Subsystem... requirements) {
        this.seconds = seconds;
        addRequirements(requirements);
    }

    /**
     * Initial subroutine of Command.
     * @see Command
     */
    public abstract void init();

    /**
     * Main body of command.
     * @see Command
     */
    public abstract void exec();

    /**
     * Action to take when command ends
     * @see Command
     */
    public abstract void end();

    @Override
    public void initialize() {
        startingTime = System.currentTimeMillis();
        this.init();
    }

    @Override
    public void execute() {
        this.exec();
    }

    @Override
    public void end(boolean interuppted) {
        this.end();
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() - startingTime > (seconds * 1000);
    }

}
