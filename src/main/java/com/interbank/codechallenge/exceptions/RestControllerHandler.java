package com.interbank.codechallenge.exceptions;

import com.interbank.codechallenge.client.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : Erojas
 * <ul>
 * <li> dateCreation : 21/12/2022 23 </li>
 * <li> fileName : RestControllerHandler.java </li>
 * <li> description : RestControllerHandler</li>
 * </ul>
 */
@RestControllerAdvice
public class RestControllerHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception exception) {
        Error error = getError(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Error builder
     *
     * @param message Message
     * @param code    Code error
     * @return Error
     */
    private Error getError(String message, int code) {
        Error error = new Error();
        error.code(code);
        error.message(message);
        return error;
    }
}
