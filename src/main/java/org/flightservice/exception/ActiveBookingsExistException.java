package org.flightservice.exception;

public class ActiveBookingsExistException extends RuntimeException{
    public ActiveBookingsExistException(String message) {
        super(message);
    }
}
