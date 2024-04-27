package lib;

import com.kauailabs.navx.frc.AHRS;

/**
 * A NavX Utility Object.
 */
public final class NavXManager {
    private final AHRS navX;

    public NavXManager(AHRS navX) {
        this.navX = navX;
    }

    public double getHeading() {
        return navX.getRotation2d().getDegrees();
    }

    public void zeroHeading() {
        this.navX.reset();
    }
}
