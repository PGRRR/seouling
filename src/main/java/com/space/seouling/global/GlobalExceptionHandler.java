package com.space.seouling.global;

import com.google.gson.Gson;
import com.space.seouling.activity.exception.EmptyCookieException;
import com.space.seouling.activity.exception.EmptyListException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BindException.class, EmptyCookieException.class})
    public void BindCatcher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestURL = String.valueOf(request.getRequestURL());
        response.sendRedirect(requestURL);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<String> categoryCatcher() {
        return ResponseEntity.internalServerError().body(ErrorCode.EMPTY_FAIL.getCode());
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception e) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("error", e.getMessage());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Gson().toJson(response));
//    }

}
