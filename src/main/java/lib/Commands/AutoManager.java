package lib.Commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public final class AutoManager {
    private static SendableChooser<Command> autoMenu = null;

    private AutoManager() {
    }

    public static SendableChooser<Command> getAutoMenu() {
        if (autoMenu == null) {
            autoMenu = new SendableChooser<>();
        }

        return autoMenu;
    }

    public static Command doNothing() {
        return new InstantCommand();
    }
}
