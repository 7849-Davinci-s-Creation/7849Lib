package lib;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Tests {
    private static class TestSubsystem implements DashboardConfiguration {
        public boolean ran = false;
        @Override
        public void configureDashboard() {
            ran = true;
        }
    }

    @Test
    public void testDashboardConfiguration() {
        // test that list is empty initially
        assertTrue(DashboardManager.dashboards.isEmpty());
        TestSubsystem subsystem = new TestSubsystem();

        DashboardManager.addSubsystemDashboard(subsystem);
        
        // test that dashboards size is now 1
        assertEquals(1, DashboardManager.dashboards.size());

        // configure all dashboards and check if it successfully executed their methods
        DashboardManager.configureDashboards();
        assertTrue(subsystem.ran);
    }

}
