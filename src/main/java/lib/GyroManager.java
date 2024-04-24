package lib;

import com.ctre.phoenix6.hardware.Pigeon2;
 
public final class GyroManager {
    public static Pigeon2 getPigeon2(int deviceNumber) {
        return new Pigeon2(deviceNumber);
    }
}
