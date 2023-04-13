package com.space.seouling.activity.controller;

import com.space.seouling.activity.domain.Activity;
import com.space.seouling.activity.dto.ActivityAdminRequestDto;
import com.space.seouling.activity.dto.ActivityRequestDto;
import com.space.seouling.activity.dto.ActivityResponseDto;
import com.space.seouling.activity.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activities")
public class ActivityController {


    private final ActivityService activityService;

    @GetMapping("/{acti_cd}")
    public ResponseEntity<List<ActivityResponseDto>> viewAct(@Valid ActivityRequestDto activityRequestDto){
        return new ResponseEntity<>(activityService.viewAct(activityRequestDto), HttpStatus.OK);
    }

    @GetMapping("/location")
    public ResponseEntity<Integer> countLocation(String addr) {
        return new ResponseEntity<>(activityService.countLocation(addr), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Integer> addAct(@RequestBody List<Activity> activityList) {
        return new ResponseEntity<>(activityService.saveAct(activityList), HttpStatus.OK);
    }

}
