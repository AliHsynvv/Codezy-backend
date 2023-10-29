package com.example.Team.enums;

import lombok.Getter;


@Getter
public enum ErrorCodeEnum {
    UNKNOWN_ERROR(1000,"Unknown"),
    TEAM_NOT_FOUND(1001,"Cannot fint team with given id"),
    NOT_TEAM(1002,"Team not found"),
    VALIDATION_ERROR(1003,"Validation");




    private final int code;
    private final String message;

    ErrorCodeEnum(int code,String message){
        this.code = code;
        this.message = message;
    }


}

