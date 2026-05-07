package com.platzi.platziplayapi.domain.exceptions;

public class MovieAlreadyExistException extends RuntimeException {

    public MovieAlreadyExistException(String movieTitle) {
        super("Movie: \"" + movieTitle + "\" already exists.");
    }
}
