package com.akash.Book.exceptions;

import com.akash.Book.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleNotValidException(MethodArgumentNotValidException e) {
        ErrorMessage errorMessage = null;
        var errors = e.getAllErrors();
        if (errors != null && !errors.isEmpty()) {
            errorMessage = new ErrorMessage(400, errors.get(0).getDefaultMessage());
            return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        errorMessage = new ErrorMessage(400, "Bad request");
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoSuchElementException.class, NumberFormatException.class})
    public ResponseEntity<ErrorMessage> handleNotFoundException(Exception e) {
        ErrorMessage errorMessage = null;
        errorMessage = new ErrorMessage(400, "not found");
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ErrorMessage> messageNotReadableException(Exception e) {
        ErrorMessage errorMessage = null;
        errorMessage = new ErrorMessage(400, "Bad request");
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgument(IllegalArgumentException e) {
        ErrorMessage errorMessage = null;
        errorMessage = new ErrorMessage(400, e.getMessage());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
