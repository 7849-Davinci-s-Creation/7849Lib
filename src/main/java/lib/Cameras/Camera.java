package lib.Cameras;

import edu.wpi.first.cscore.UsbCamera;

/**
 * An Object representation of a USB Camera.
 */
public final class Camera extends UsbCamera {
    private final int width;
    private final int height;
    private final ConnectionStrategy connectionStrategy;
    private final int outputColor;

    /**
     * Creates a new Camera Object.
     * @param name Name of camera.
     * @param dev Development int.
     * @param width Width of Stream.
     * @param height Height of Stream.
     * @param connectionStrategy Way camera should connect.
     * @param outputColor Color-Scale of Output Stream.
     */
    private Camera(String name, int dev, int width, int height, ConnectionStrategy connectionStrategy, int outputColor) {
        super(name, dev);
        this.width = width;
        this.height = height;
        this.connectionStrategy = connectionStrategy;
        this.setConnectionStrategy(connectionStrategy);
        this.setResolution(width, height);
        this.outputColor = outputColor;
    }

    /**
     * Creates a new Camera object.
     * @param name Name of camera.
     * @param path Path to camera.
     * @param width Width of Stream.
     * @param height Height of Stream.
     * @param connectionStrategy Way camera should connect.
     * @param outputColor Color-Scale of Output Stream.
     */
    private Camera(String name, String path, int width, int height, ConnectionStrategy connectionStrategy, int outputColor) {
        super(name, path);
        this.width = width;
        this.height = height;
        this.connectionStrategy = connectionStrategy;
        this.setConnectionStrategy(connectionStrategy);
        this.setResolution(width, height);
        this.outputColor = outputColor;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getOutputColor() {
        return this.outputColor;
    }
}
