package com.space.seouling.activity.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorCodeList {

    /* 500 */

    ACTIVITY_INSERT_FAIL_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,"활동터 컨텐츠 추가에 실패하였습니다."),
    FAIL_TO_GET_ACTIVITY_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,"활동터 컨텐츠 읽기에 실패하였습니다."),
    FAIL_TO_GET_ACTIVITY_LIST_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,"활동터 리스트 읽기에 실패하였습니다."),
    FAIL_TO_MODIFY_ACTIVITY_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,"활동터 컨텐츠 수정에 실패하였습니다."),
    FAIL_TO_DELETE_ACTIVITY_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,"활동터 컨텐츠 삭제에 실패하였습니다."),
    FAIL_TO_MODIFY_ACTIVITY_STATE_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,"활동터 컨텐츠 상태 코드 수정에 실패하였습니다.");

    private final HttpStatus httpStatus;
    private final String detail;

}
