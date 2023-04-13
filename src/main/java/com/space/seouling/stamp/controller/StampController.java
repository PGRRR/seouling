//package com.space.seouling.stamp.controller;
//
//import com.space.seouling.activity.exception.EmptyCookieException;
//import com.space.seouling.global.ErrorCode;
//import com.space.seouling.stamp.dto.StampRequestDto;
//import com.space.seouling.stamp.dto.StampResponseDto;
//import com.space.seouling.stamp.service.StampService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpSession;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/stamps")
//public class StampController {
//
//    private final StampService stampService;
//
//    @GetMapping("")
//    public ResponseEntity<List<StampResponseDto>> viewStamp(@CookieValue(value = "JSESSIONID", required = false) Cookie user, HttpSession session) {
//        return new ResponseEntity<>(stampService.viewStampList(getUserId(user)), HttpStatus.OK);
//    }
//
//    @GetMapping("/shared")
//    public ResponseEntity<List<StampResponseDto>> viewSharedStamp(String id) {
//        return new ResponseEntity<>(stampService.viewStampList(id), HttpStatus.OK);
//    }
//
//    @GetMapping("/cookie")
//    public ResponseEntity<String> readCookie(@CookieValue(value = "JSESSIONID", required = false) Cookie user, HttpSession session) {
//        return new ResponseEntity<>(getUserId(user), HttpStatus.OK);
//    }
//
//    @PostMapping("/{acti_id}")
//    public ResponseEntity<Integer> addStamp(@CookieValue(value = "JSESSIONID", required = false) Cookie user, HttpSession session, StampRequestDto requestDto) {
//        String userId = getUserId(user);
//        requestDto.setUser_id(userId);
//        return new ResponseEntity<>(stampService.addStamp(requestDto), HttpStatus.OK);
//    }
//
//    @PutMapping("/{acti_id}")
//    public ResponseEntity<Integer> modifyStamp(@CookieValue(value = "JSESSIONID", required = false) Cookie user, HttpSession session, StampRequestDto requestDto) {
//        requestDto.setUser_id(getUserId(user));
//        return new ResponseEntity<>(stampService.modifyStampSeq(requestDto), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{acti_id}")
//    public ResponseEntity<Integer> deleteStamp(@CookieValue(value = "JSESSIONID", required = false) Cookie user, HttpSession session, StampRequestDto requestDto) {
//        requestDto.setUser_id(getUserId(user));
//        return new ResponseEntity<>(stampService.removeStamp(requestDto), HttpStatus.OK);
//    }
//
//    private static String getUserId(Cookie user) {
//        return Optional.ofNullable(user).orElseThrow(()-> new EmptyCookieException("empty_cookie", ErrorCode.COOKIE_FAIL)).getValue();
//    }
//
//}
