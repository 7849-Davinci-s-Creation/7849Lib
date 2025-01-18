package lib;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.networktables.DoubleArrayPublisher;
import edu.wpi.first.networktables.NetworkTable;

import java.util.function.Supplier;

public final class LoggingHelper {
    private final NetworkTable table;

    public LoggingHelper(NetworkTable table) {
        this.table = table;
    }

    public void logPose(Supplier<Pose2d> poseSupplier) {
        DoubleArrayPublisher loggedPose = table.getDoubleArrayTopic("LoggedPose").publish();

        Pose2d pose = poseSupplier.get();

        loggedPose.set(new double[] {
                pose.getX(),
                pose.getY(),
                pose.getRotation().getDegrees()
        });
    }

}
