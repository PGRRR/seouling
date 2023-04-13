package com.space.seouling.activity.exception;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.tools.shell.IO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@ControllerAdvice
public class GlobalCatcher{

    @ExceptionHandler(value = {DuplicateKeyException.class})
    protected void handleDataException(HttpServletResponse response, HttpServletRequest request) throws IOException{
        log.error("ACTIVITY_INSERT_FAIL_EXCEPTION throw Exception", ErrorCodeList.ACTIVITY_INSERT_FAIL_EXCEPTION);
        String url = String.valueOf(request.getRequestURL());
        response.sendRedirect(url);
    }

    @ExceptionHandler(value = {CustomException.class })
    protected void handleCustomException(HttpServletResponse response) throws IOException {
        log.error("CUSTOM_EXCEPTION throw CustomException");
        response.sendRedirect("/admin/main");
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected void handleIllegalArgumentException(HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.error("IllegalArgumentException 발생");
        String url = String.valueOf(request.getRequestURL());
        response.sendRedirect(url);
    }

    @ExceptionHandler(value = {IOException.class})
    protected void handleIOException(HttpServletRequest request, HttpServletResponse response){
        log.error("IOException 발생");
    }

}

