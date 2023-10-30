package com.example.Team.controller.response;
import com.example.Team.controller.response.ErrorResponse;
import com.example.Team.enums.ErrorCodeEnum;
import com.example.Team.exception.TeamNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(TeamNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleTeamNotFoundException(TeamNotFoundException e){
        return ErrorResponse.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ErrorResponse handlerUnknownerror(Exception e){
        return  ErrorResponse.builder()
                .code(ErrorCodeEnum.UNKNOWN_ERROR.getCode())
                .message(ErrorCodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }
}
