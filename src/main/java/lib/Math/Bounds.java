package lib.Math;

/**
 * Code representation of a higher and lower bound.
 */
public class Bounds {
    private final int lowerBound;
    private final int higherBound;

    public Bounds(int lowerBound, int higherBound) {
        this.lowerBound = lowerBound;
        this.higherBound = higherBound;
    }

    public int getHigherBound() {
        return higherBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }
}
