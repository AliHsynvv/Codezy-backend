package com.company.codezybackend.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {
    UNKNOWN_ERROR(1000, "Unknown error!"),
    Training_NOT_FOUND(1001, "Cannot find training with given id!"),
    NOT_ENOUGH_Training(1002, "Training not found!"),
    NOT_ENOUGH_STUDENTS(1003, "Students not found!"),
    STUDENTS_NOT_FOUND(1004, "Cannot find students with given id!"),
    INVALID_FILE(1005,"File is invalid!");


    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
