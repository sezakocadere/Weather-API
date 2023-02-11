package com.weather.weather.exception;

public class NotFoundCity extends RuntimeException {
    public NotFoundCity(String message) {
        super(message);
    }
}
