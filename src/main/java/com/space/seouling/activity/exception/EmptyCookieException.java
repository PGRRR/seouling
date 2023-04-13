package com.space.seouling.activity.exception;

import com.space.seouling.global.ErrorCode;
import lombok.Getter;

@Getter
public class EmptyCookieException extends RuntimeException{
    private final ErrorCode errorCode;

    public EmptyCookieException(String message, ErrorCode errorCode) {
        super(errorCode.getMessage() + message);
        this.errorCode = errorCode;
    }
}