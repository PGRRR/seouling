package com.space.seouling.stamp.controller;

import com.space.seouling.activity.dto.ActivityResponseDto;
import com.space.seouling.activity.exception.EmptyListException;
import com.space.seouling.activity.service.ActivityService;
import com.space.seouling.global.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stamps")
public class StampRestController {

    private final ActivityService activityService;

    @GetMapping("")
    public ResponseEntity<List<ActivityResponseDto>> viewStamp(@CookieValue(required = false) Cookie seqCookie, @RequestParam(value = "seq", required = false) List<Integer> seq) {
        if (seqCookie != null) {
            String[] split = seqCookie.getValue().split(",");
            List<Integer> integerList = new ArrayList<>();
            for (String s : split) {
                integerList.add(Integer.parseInt(s));
            }
            return new ResponseEntity<>(activityService.viewStamp(integerList), HttpStatus.OK);
        }
        if (seq != null) {
            return new ResponseEntity<>(activityService.viewStamp(seq), HttpStatus.OK);
        }
        throw new EmptyListException("스탬프 조회 실패", ErrorCode.EMPTY_FAIL);
    }

    @PostMapping("")
    public ResponseEntity<List<ActivityResponseDto>> editStamp(@RequestParam(value = "seq", required = false) List<Integer> seq, HttpServletResponse response) {
        if (seq != null) {
            String seqString = seq.toString().substring(1, seq.toString().length() - 1);
            Cookie seqCookie = new Cookie("seqCookie", seqString);
            seqCookie.setPath("/");
            response.addCookie(seqCookie);
        } else {
            throw new EmptyListException("스탬프 저장 실패", ErrorCode.EMPTY_FAIL);
        }
        return new ResponseEntity<>(activityService.viewStamp(seq), HttpStatus.OK);
    }

}
