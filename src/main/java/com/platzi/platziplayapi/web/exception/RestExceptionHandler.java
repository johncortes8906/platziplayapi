package com.platzi.platziplayapi.web.exception;

import com.platzi.platziplayapi.domain.exceptions.MovieAlreadyExistException;
import com.platzi.platziplayapi.domain.exceptions.MovieDoesntExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistException e) {
        Error error = new Error("movie-already-exist", e.getMessage());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieDoesntExistException.class)
    public ResponseEntity<Error> handleException(MovieDoesntExistException e) {
        Error error = new Error("movie-doesnt-exist", e.getMessage());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException e) {
        List<Error> errors = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(error -> {
            errors.add(new Error(error.getField(), error.getDefaultMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception e) {
        return ResponseEntity.badRequest().body(new Error("unknown-error", e.getMessage()));
    }
}
