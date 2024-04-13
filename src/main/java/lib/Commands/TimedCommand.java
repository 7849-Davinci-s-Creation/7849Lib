package lib.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;

public abstract class TimedCommand extends Command {
    private final double seconds;

    private double startingTime;
    public TimedCommand(double seconds, Subsystem... requirements) {
        this.seconds = seconds;
        addRequirements(requirements);
    }

    public abstract void init();
    public abstract void exec();
    public abstract void finished();

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
        this.finished();
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() - startingTime > (seconds * 1000);
    }

}
