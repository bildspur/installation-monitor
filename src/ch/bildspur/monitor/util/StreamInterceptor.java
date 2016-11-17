package ch.bildspur.monitor.util;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by cansik on 15.11.16.
 */
public class StreamInterceptor extends PrintStream {
    StreamMessage[] messages;
    int pos = -1;

    public StreamInterceptor(OutputStream out) {
        this(out, 10);
    }

    public StreamInterceptor(OutputStream out, int bufferSize) {
        super(out, true);
        messages = new StreamMessage[bufferSize];
    }

    private void add(String s) {
        pos = (pos + 1) % messages.length;
        messages[pos] = new StreamMessage(s);
    }

    public StreamMessage[] getAll() {
        StreamMessage[] result = new StreamMessage[messages.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = messages[Math.floorMod(pos - i, messages.length)];
        }

        return result;
    }

    @Override
    public void print(String s) {
        super.print(s);
        add(s);
    }
}