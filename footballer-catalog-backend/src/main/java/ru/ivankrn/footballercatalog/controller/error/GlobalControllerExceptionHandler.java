package ru.ivankrn.footballercatalog.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    public static final String NOT_FOUND_MESSAGE = "Not found";
    public static final String VALIDATION_MESSAGE = "Validation error";
    public static final String WRONG_ARGUMENT_TYPE_MESSAGE = "Wrong argument type";

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new ErrorResponse(status, NOT_FOUND_MESSAGE));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<String> validationErrors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError ->
                validationErrors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage()));
        exception.getBindingResult().getGlobalErrors().forEach(globalError ->
                validationErrors.add(globalError.getObjectName() + ": " + globalError.getDefaultMessage()));
        return ResponseEntity.status(status).body(new ErrorResponse(status, VALIDATION_MESSAGE, validationErrors));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String info =
                exception.getName() + " should be of type " + exception.getRequiredType().getName();
        return ResponseEntity.status(status).body(new ErrorResponse(status, WRONG_ARGUMENT_TYPE_MESSAGE, info));
    }

}