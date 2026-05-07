package com.platzi.platziplayapi.web.exception;

import com.platzi.platziplayapi.domain.exceptions.MovieAlreadyExistException;
import com.platzi.platziplayapi.domain.exceptions.MovieDoesntExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
