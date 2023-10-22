package com.company.codezybackend.controller.response;

import com.company.codezybackend.exception.StudentsException;
import com.company.codezybackend.exception.TrainingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerStudents {
    @ExceptionHandler(StudentsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCustomNotFoundException(StudentsException t) {
        return ErrorResponse.builder()
                .code(t.getCode())
                .message(t.getMessage())
                .build();
    }
}
