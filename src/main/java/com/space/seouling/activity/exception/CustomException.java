package com.space.seouling.activity.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private final ErrorCodeList errorCodeList;

    @Override
    public String getMessage() {
        return errorCodeList.getDetail();
    }

}
