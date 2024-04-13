package lib.Cameras;

import edu.wpi.first.cscore.UsbCamera;

public final class Camera extends UsbCamera {
    private final int width;
    private final int height;
    private final ConnectionStrategy connectionStrategy;
    private final int outputColor;

    private Camera(String name, int dev, int width, int height, ConnectionStrategy connectionStrategy, int outputColor) {
        super(name, dev);
        this.width = width;
        this.height = height;
        this.connectionStrategy = connectionStrategy;
        this.setConnectionStrategy(connectionStrategy);
        this.setResolution(width, height);
        this.outputColor = outputColor;
    }

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
