package com.space.seouling.global;

import com.space.seouling.activity.exception.EmptyCookieException;
import com.space.seouling.activity.exception.EmptyListException;
import lombok.Getter;

@Getter
public enum ErrorCode {

    EMPTY_FAIL(500, "empty_object", "빈 객체", EmptyListException.class),
    COOKIE_FAIL(500, "empty_object", "빈 쿠키 값", EmptyCookieException.class);

    private final int status;
    private final String code;
    private final String message;
    private final Class<? extends RuntimeException> classType;

    ErrorCode(int status, String code, String message, Class<? extends RuntimeException> classType) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.classType = classType;
    }
}
