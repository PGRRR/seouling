package com.space.seouling.activity.controller;

import com.space.seouling.activity.dto.ActivityAdminRequestDto;
import com.space.seouling.activity.dto.ActivityAdminResponseDto;
import com.space.seouling.activity.service.ActivityAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class RestActivityAdminController {

    private final ActivityAdminService activityAdminService;

    /*
     *       Get Json Data From page, Parse Json data to DTO, Insert to Database
     * */
    @PostMapping("/contentAddJson")
    public ResponseEntity<?> insertJson(@RequestBody ActivityAdminRequestDto[] activityDtos) {

        /*
         *       Parsing 성공시 200번 return
         *       Parsing 실패시(NUll 등) 500번 return
         * */
        if(activityDtos!=null){
            /*
             *   ACTIVITY_TB의 ttl로 조회하여 중복된 데이터인지 조회 후,
             *   중복된 데이터가 아닐 경우에만 Insert 진행
             * */
            for(ActivityAdminRequestDto a : activityDtos){
                ActivityAdminResponseDto activityDto = activityAdminService.getActivityTitle(a.getTtl());
                System.out.println(activityDto);
                if(activityDto==null){
                    activityAdminService.addActivity(a);
                }
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*
     *       Get Json Data From page, Parse Json data to DTO, Update to Database
     * */
    @PostMapping("/contentEditJson")
    public ResponseEntity<?> modifyJson(@RequestBody ActivityAdminRequestDto[] activityDtos) {
        int cnt = 0;
        /*
         *       Parsing 성공시 200번 return
         *       Parsing 실패시(NUll 등) 500번 return
         * */
        if(activityDtos!=null){
            /*
             *   Loop를 돌면서 JSON Parsing 하여 업데이트 진행
             * */
            for(ActivityAdminRequestDto a : activityDtos){
                int result = activityAdminService.modifyActivity(a);
                if(result == 1){
                    // 업데이트 된 행의 갯수를 저장, ReponseEntity에 담아서 전송
                    cnt++;
                }
            }
            return new ResponseEntity<>(cnt,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(cnt,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*
     *   Modify Activity State Activate
     * */
    @PostMapping("/contentEdit/stateActive")
    public ResponseEntity<?> modifyStateAct(Integer acti_id) {

        // MyBatis Query Parameter Map 생성
        Map map = new HashMap();
        map.put("acti_id",acti_id);
        map.put("act_yn",1);

        // Modify로 영향 받은 row수를 return
        int result = activityAdminService.modifyActivityState(map);

        /*
         *   result가 1이면 SUCCESS(200) return
         *   result가 1이 아닐경우, INTERNAL_SERVER_ERROR(500) return
         * */
        if(result == 1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /*
     *   Modify Activity State Disabled
     * */
    @PostMapping("/contentEdit/stateDisabled")
    public ResponseEntity<?> modifyStateDis(Integer acti_id) {
        // MyBatis Query Parameter Map 생성
        Map map = new HashMap();
        map.put("acti_id",acti_id);
        map.put("act_yn",0);

        // Modify로 영향 받은 row수를 return
        int result = activityAdminService.modifyActivityState(map);

        /*
         *   result가 1이면 SUCCESS(200) return
         *   result가 1이 아닐경우, INTERNAL_SERVER_ERROR(500) return
         * */
        if(result == 1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     *   Delete activity
     * */
    @DeleteMapping("/contentDelete")
    public ResponseEntity<?> deleteActivity(Integer acti_id) {

        // 활동터 테이블의 PK인 acti_id로 활동터 게시글 한개를 삭제 수행
        int result = activityAdminService.deleteActivity(acti_id);

        // 성공할 경우, View로 SUCESS(200)을 return
        // 실패할 경우, View로 INTERNAL_SERVER_ERROR(500)을 return
        if(result == 1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
