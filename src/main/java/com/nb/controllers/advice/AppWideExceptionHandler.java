package com.nb.controllers.advice;

import com.nb.exceptions.DuplicateSpitterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Nidhia Bhasin on 23-08-2017.
 */
@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(DuplicateSpitterException.class)
    public String duplicateSpittleHandler() {
        return "error/duplicate";
    }
}
