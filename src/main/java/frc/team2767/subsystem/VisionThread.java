package frc.team2767.subsystem;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.*;
import org.opencv.imgproc.*;

import java.util.ArrayList;

public class VisionThread implements Runnable {
  private static double camWidthPix;
  private static double camHeightPix;
  private static double camWidthDeg = 30;

  private static Thread thread;
  ArrayList<MatOfPoint> contours;
  static GripPipeline PIPELINE;
  CvSink cvSink;
  Mat source = new Mat();

  private Rect boundingRect;

  public VisionThread() {
    PIPELINE = new GripPipeline();
    thread = new Thread(this);

    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(640, 480);
    camera.setBrightness(0);

    cvSink = CameraServer.getInstance().getVideo();
  }

  @Override
  public void run() {
    cvSink.grabFrame(source);
    PIPELINE.process(source);
    contours = PIPELINE.filterContoursOutput();
  }

  public void readCamera() {
    thread.start();
  }

  private double getAngle () {
    run();
    boundingRect = Imgproc.boundingRect(contours.get(0));
    double center = boundingRect.x + (boundingRect.width / 2.0);
    double angle = ((center / camWidthPix) - (camWidthPix / 2)) * camWidthDeg / 2;
    return angle;
  }
}
