package lib.Cameras;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.util.Arrays;
import java.util.HashMap;

/**
 * A utility Object for the WPILib CameraServer
 * @see CameraServer
 */
public final class CameraServerManager {
    private final Camera[] cameras;
    private final CvSink[] cvSinks;
    private final Mat[] sources;
    private final Mat[] outputs;

    private final HashMap<String, CvSource> outputStreams = new HashMap<>();

    /**
     * Create a new CameraServerManager Objects
     * @param cameras Cameras to have utilized the WPILib Camera server.
     */
    public CameraServerManager(Camera... cameras) {
        this.cameras = cameras;
        int numOfCameras = cameras.length;
        this.sources = new Mat[numOfCameras];
        this.outputs = new Mat[numOfCameras];
        this.cvSinks = new CvSink[numOfCameras];

        Arrays.fill(sources, new Mat());
        Arrays.fill(outputs, new Mat());

        for (int i = 0; i < cvSinks.length; i++) {
            cvSinks[i] = CameraServer.getVideo(cameras[i].getName());
        }

        for (Camera camera : cameras) {
            outputStreams.put(camera.getName(), CameraServer.putVideo(camera.getName(), camera.getWidth(), camera.getHeight()));
        }
    }

    /**
     * Starts streaming all provided cameras to the CameraServer
     * @see CameraServer
     */
    public void startCameras() {
        new Thread(() -> {
            while (!Thread.interrupted()) {
                for (int i = 0; i < cvSinks.length; i++) {
                    if (cvSinks[i].grabFrame(sources[i]) == 0) {
                        continue;
                    }
                    modifyCameraColor(sources[i], outputs[i], cameras[i].getOutputColor());
                    outputStreams.get(cameras[i].getName()).putFrame(outputs[i]);
                }
            }
        }).start();
    }

    private void modifyCameraColor(Mat source, Mat output, int color) {
        Imgproc.cvtColor(source, output, color);
    }
}
