package ch.bildspur.monitor.util;

import java.time.LocalDateTime;

/**
 * Created by cansik on 17.11.16.
 */
public class StreamMessage {
    private final String message;
    private final LocalDateTime dateTime;

    public StreamMessage(String message) {
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }

    public StreamMessage(String message, LocalDateTime dateTime) {
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
