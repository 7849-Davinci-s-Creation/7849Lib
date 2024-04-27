package lib.FunctionalInterfaces;

/**
 * A functional interface representation of a differential drive function.
 * (Arcade drive, Tank drive, Curved Drive).
 */
@FunctionalInterface
public interface DifferentialDrive {
    void differentialDrive(double value1, double value2);
}
