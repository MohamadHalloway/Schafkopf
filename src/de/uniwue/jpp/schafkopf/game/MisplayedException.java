package de.uniwue.jpp.schafkopf.game;

public class MisplayedException extends RuntimeException {

    public MisplayedException() {
        super();
    }

    public MisplayedException(String message) {
        super(message);
    }

    public MisplayedException(String message, Throwable cause) {
        super(message, cause);
    }
}
