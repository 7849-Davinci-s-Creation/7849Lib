package lib;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public final class GyroManager {
    public static Pigeon2 getPigeon2(int deviceNumber) {
        return new Pigeon2(deviceNumber);
    }
    public static AHRS getNavX(SPI.Port port) {
        return new AHRS(port);
    }
}
