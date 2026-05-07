package com.platzi.platziplayapi.domain.exceptions;

public class MovieDoesntExistException extends RuntimeException {

    public MovieDoesntExistException(Long id) {

        super("The movie with ID: " + id + " doesn't exist.");
    }
}
