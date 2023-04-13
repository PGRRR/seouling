package com.space.seouling.activity.exception;

import com.space.seouling.global.ErrorCode;
import lombok.Getter;

@Getter
public class EmptyListException extends RuntimeException{
    private final ErrorCode errorCode;

    public EmptyListException(String message, ErrorCode errorCode) {
        super(errorCode.getMessage() + message);
        this.errorCode = errorCode;
    }
}