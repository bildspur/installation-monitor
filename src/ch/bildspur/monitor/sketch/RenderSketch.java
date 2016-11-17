package ch.bildspur.monitor.sketch;

import ch.bildspur.monitor.util.StreamInterceptor;
import ch.bildspur.monitor.util.StreamMessage;
import processing.core.PApplet;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;

/**
 * Created by cansik on 17.11.16.
 */
public class RenderSketch extends PApplet {

    public final static String VERSION = "2.1";
    public final static String APPLICATION_NAME = "Installation Monitor";
    public final static String CONFIG_NAME = "config.json";

    public final static int OUTPUT_WIDTH = 400;
    public final static int OUTPUT_HEIGHT = 150;

    public final static int FRAME_RATE = 5;

    StreamInterceptor interceptor;

    public void settings() {
        size(OUTPUT_WIDTH, OUTPUT_HEIGHT, FX2D);
    }

    public void setup() {
        frameRate(FRAME_RATE);
        surface.setTitle(APPLICATION_NAME + " - " + VERSION);

        setupInterceptor();

        println(APPLICATION_NAME + " - " + VERSION);
    }

    public void draw() {
        background(120);
        showOutput();
    }

    private void showOutput() {
        StreamMessage[] msgs = interceptor.getAll();

        fill(55);
        textAlign(LEFT, BOTTOM);
        textSize(10);

        for (int i = 0; i < msgs.length; i++) {
            StreamMessage msg = msgs[msgs.length - i - 1];
            if (msg != null)
                text(msg.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                        + ": " + msg.getMessage(), 5, height - (12 * i));
        }
    }

    private void setupInterceptor() {
        PrintStream origOut = System.out;
        interceptor = new StreamInterceptor(origOut);
        System.setOut(interceptor);
    }
}
