package lib;

import java.util.ArrayList;

/**
 * A utility classed that houses a list of all subsystems that implement the Dashboard Configuration class to be configured
 * and any useful Smartdashboard utility.
 * @see DashboardConfiguration
 */
@Deprecated
public final class DashboardManager {
    /**
     * List of subsystems that implement this interface to configure dashboards for.
     */
    public static final ArrayList<DashboardConfiguration> dashboards = new ArrayList<>();

    /**
     * Adds a subsystem's dashboard configuration to the list of dashboards.
     * @param subsystem Subsystem to add to list.
     */
    public static void addSubsystemDashboard(DashboardConfiguration subsystem) {
        dashboards.add(subsystem);
    }

    /**
     * Configures all subsystem's dashboards in the dashboards list
     */
    public static void configureDashboards() {
        if (dashboards.isEmpty()) {
            return;
        }

        dashboards.forEach(DashboardConfiguration::configureDashboard);
    }
}
