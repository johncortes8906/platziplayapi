package com.platzi.platziplayapi.web.exception;

public record Error (
        String errorType,
        String message
){
}
