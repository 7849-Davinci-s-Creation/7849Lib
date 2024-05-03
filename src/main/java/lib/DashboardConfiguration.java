package lib;

/**
 * Provides a nice method to configure a dashboard with.
 * (This interface's method should be called via a subsystems periodic method.)
 * @see edu.wpi.first.wpilibj2.command.SubsystemBase
 */
@FunctionalInterface
public interface DashboardConfiguration {
    void configureDashboard();
}
