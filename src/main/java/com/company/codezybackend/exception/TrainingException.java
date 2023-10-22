package com.company.codezybackend.exception;

import com.company.codezybackend.enums.ErrorCodeEnum;
import lombok.Getter;

@Getter
public class TrainingException extends RuntimeException {
    private final String message;
    private final int code;

    public TrainingException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.message = errorCodeEnum.getMessage();
        this.code = errorCodeEnum.getCode();
    }
}
