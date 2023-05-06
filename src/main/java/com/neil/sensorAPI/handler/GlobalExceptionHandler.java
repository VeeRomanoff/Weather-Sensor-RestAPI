package com.neil.sensorAPI.handler;

import com.neil.sensorAPI.utils.ErrorDetails;
import com.neil.sensorAPI.utils.SensorAlreadyExistsException;
import com.neil.sensorAPI.utils.SensorNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SensorNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleException(SensorNotFoundException ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(
                ex.getMessage(),
                request.getDescription(false),
                LocalTime.now());

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SensorAlreadyExistsException.class)
    public final ResponseEntity<ErrorDetails> handleSensorAlreadyExistsException(SensorAlreadyExistsException ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(
                ex.getMessage(),
                request.getDescription(false),
                LocalTime.now()
        );

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(
                ex.getMessage(),
                request.getDescription(false),
                LocalTime.now()
        );

        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                ex.getFieldError().getDefaultMessage(),
                request.getDescription(false),
                LocalTime.now()
        );

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
