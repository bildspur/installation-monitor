package ch.bildspur.monitor;

import ch.bildspur.monitor.sketch.RenderSketch;
import processing.core.PApplet;

public class Main {

    public static void main(String[] args) {
        RenderSketch sketch = new RenderSketch();
        PApplet.runSketch(new String[]{"ch.bildspur.monitor.sketch.RenderSketch "}, sketch);
    }
}
