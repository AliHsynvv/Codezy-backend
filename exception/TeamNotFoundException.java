package com.example.Team.exception;

import com.example.Team.enums.ErrorCodeEnum;
import lombok.Getter;

@Getter
public class TeamNotFoundException extends RuntimeException{
    private final String message;
    private final int code;

    public TeamNotFoundException(ErrorCodeEnum errorCodeEnum){

        super(errorCodeEnum.getMessage());
        this.message=errorCodeEnum.getMessage();
        this.code=errorCodeEnum.getCode();
    }
}
