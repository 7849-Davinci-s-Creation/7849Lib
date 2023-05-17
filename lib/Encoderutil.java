public class Encoderutil {
    /** 
     * Takes a REV internal encoder position and converts it to feet.
     * NOTE: This algorithm only works for 6 inch diameter wheels, with 
     * a 5.95:1 gear ratio.
     * @param encoderPosition rev internal encoder position
     * @return encoder position converted to feet
     */
    public double ticks2Feet(double encoderPosition) {
        return encoderPosition * ((6*Math.PI)/71.4);
    }
}
