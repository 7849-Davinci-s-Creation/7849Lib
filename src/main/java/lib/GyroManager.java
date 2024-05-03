package lib;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

/**
 * Utility class for managing different gyros.
 */
public final class GyroManager {
    /**
     * Retrieve an instance of a Pigeon2 gyro.
     * @param deviceNumber Port number of device.
     * @return An instance of a Pigeon2 Object
     */
    public static Pigeon2 getPigeon2(int deviceNumber) {
        return new Pigeon2(deviceNumber);
    }

    /**
     * Retrieve an instance of a NavX object.
     * @param port SPI port of device.
     * @return
     */
    public static AHRS getNavX(SPI.Port port) {
        return new AHRS(port);
    }
}
