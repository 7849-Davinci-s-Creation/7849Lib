package lib.Math;

/**
 * Code representation of a higher and lower bound.
 */
public class Bounds {
    private final double lowerBound;
    private final double higherBound;

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
}
