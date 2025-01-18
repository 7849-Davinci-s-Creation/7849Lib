package lib.Math;

/**
 * Code representation of a higher and lower bound.
 */
public class Bounds {
    private final double lowerBound;
    private final double higherBound;

    /**
     * Creates a bound representing values between lower to higher bounds.
     * @param lowerBound Lower bound.
     * @param higherBound Higher bound.
     */
    public Bounds(double lowerBound, double higherBound) {
        this.lowerBound = lowerBound;
        this.higherBound = higherBound;
    }

    public double getHigherBound() {
        return higherBound;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    /**
     * Checks if a passed value is within the object's defined range.
     * @param value Wanted value to check.
     * @return True if in range.
     */
    public boolean isInBounds(double value) {
        return value >= lowerBound && value <= higherBound;
    }
}
