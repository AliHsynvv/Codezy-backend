package com.company.codezybackend.controller.response;

import com.company.codezybackend.exception.TrainingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(TrainingException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCustomNotFoundException(TrainingException t) {
        return ErrorResponse.builder()
                .code(t.getCode())
                .message(t.getMessage())
                .build();
    }
}
