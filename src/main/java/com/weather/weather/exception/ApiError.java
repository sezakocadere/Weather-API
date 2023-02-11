package com.weather.weather.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiError {
    private final String message;
    private final HttpStatus status;
    private final String timeStamp;
}
