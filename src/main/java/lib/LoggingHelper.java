package lib;

import com.ctre.phoenix6.swerve.SwerveDrivetrain.SwerveDriveState;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.networktables.DoubleArrayPublisher;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StructArrayPublisher;

import java.util.function.Supplier;

/**
 * Useful attributes and methods for logging data via NetworkTables.
 * 
 * @see NetworkTableInstance
 */
public final class LoggingHelper {
    /** NetworkTable to be logging to. */
    private final NetworkTableInstance table;

    private final StructArrayPublisher<SwerveModuleState> swerveStates;

    private final SwerveModuleState[] states = new SwerveModuleState[] {
            new SwerveModuleState(),
            new SwerveModuleState(),
            new SwerveModuleState(),
            new SwerveModuleState()
    };

    /**
     * Creates an instance of the LoggingHelper Object.
     * 
     * @param table NetworkTable to be logging to.
     * @see NetworkTableInstance
     */
    public LoggingHelper(NetworkTableInstance table) {
        this.table = table;

        swerveStates = table
                .getStructArrayTopic("Swerve-Module-States", SwerveModuleState.struct).publish();
    }

    /**
     * Logs a given pose to the NetworkTable.
     * 
     * @param poseSupplier Pose to log.
     * @param name         Name of Table Entry.
     * @see Pose2d
     */
    public void logPose(Supplier<Pose2d> poseSupplier, String name) {
        DoubleArrayPublisher loggedPose = table.getDoubleArrayTopic(name).publish();

        Pose2d pose = poseSupplier.get();

        loggedPose.set(new double[] {
                pose.getX(),
                pose.getY(),
                pose.getRotation().getDegrees()
        });
    }

    /**
     * Logs all Swerve Module's current states (this is set up to be used in
     * advantage scope's Swerve state visualizer).
     * 
     * @param swerveDriveState Phoenix 6's SwerveDriveState object (From TunerX
     *                         swerve code generator).
     * @see SwerveModuleState
     */
    public void logSwerveModuleStates(SwerveDriveState swerveDriveState) {
        for (int i = 0; i < 4; i++) {

            states[i] = new SwerveModuleState(swerveDriveState.ModuleStates[i].speedMetersPerSecond,
                    swerveDriveState.ModuleStates[i].angle);

            swerveStates.set(states);
        }

    }

}
