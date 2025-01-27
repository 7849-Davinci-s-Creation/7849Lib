package lib;

public interface RobotMethods {
     void robotPeriodic();

     void disabledInit();

     void disabledPeriodic();

     void disabledExit();

     void autonomousInit();

     void autonomousPeriodic();

     void autonomousExit();

     void teleopInit();

     void teleopPeriodic();

     void teleopExit();

     void testInit();

     void testPeriodic();

     void testExit();

     void simulationPeriodic();
}
