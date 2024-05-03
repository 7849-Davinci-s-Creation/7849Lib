package lib.Commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * Object for managing autonomous logic.
 */
public final class AutoManager {
    /**
     * Singleton Instance of Auto Chooser menu.
     * @see SendableChooser
     */
    private static SendableChooser<Command> autoMenu = null;

    private AutoManager() {
    }

    /**
     * Retrieves the singleton instance of an Autonomous Menu.
     * @return instance of the singleton Autonomous Menu.
     */
    public static SendableChooser<Command> getAutoMenu() {
        if (autoMenu == null) {
            autoMenu = new SendableChooser<>();
        }

        return autoMenu;
    }

    /**
     * A command that does absolutely nothing!
     * @return Empty instant command.
     */
    public static Command doNothing() {
        return new InstantCommand();
    }
}
