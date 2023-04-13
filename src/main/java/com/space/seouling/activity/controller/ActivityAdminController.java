package com.space.seouling.activity.controller;

import com.space.seouling.activity.dto.ActivityAdminRequestDto;
import com.space.seouling.activity.dto.ActivityAdminResponseDto;
import com.space.seouling.activity.dto.PageHandler;
import com.space.seouling.activity.service.ActivityAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ActivityAdminController {

    private final ActivityAdminService activityAdminService;

    /*
    *      Admin Common Page
    * */
    @GetMapping("/main")
    public String adminMain(){
        return "common_admin";
    }


    /*
    *   Admin Activity insert page
    * */
    @GetMapping("/contentAdd")
    public String insertActivity(){
        return "activity_insert";
    }

    /*
    *   Insert activity to database
    * */
    @PostMapping("/contentAdd")
    public String insertActivity(ActivityAdminRequestDto requestDto) {

        // insert 결과를 변수에 저장
        int result = activityAdminService.addActivity(requestDto);
        return "common_admin";
    }

    /*
    *   Show all activities
    * */
    @GetMapping("/contentList")
    public String getAllActivity(/*@RequestParam(value = "page", defaultValue = "1") int page*/ Model model) {

        // 페이징 처리를 위해 활동터 게시글의 갯수를 조회
        int activityCnt = activityAdminService.getActivityCnt();

        // 현재 페이지와 게시글의 갯수로 Limit과 Offset을 계산
//        PageHandler pageHandler = new PageHandler(activityCnt,page);

        // 활동터 게시글을 List에 담아서 받아온다.
        List<ActivityAdminResponseDto> activityList = activityAdminService.getAllActivity();

        // List에 담겨진 활동터 게시글을 View에 전달
        model.addAttribute("activityList",activityList);
        model.addAttribute("listCnt",activityCnt);
        return "activity_list";
    }

    /*
    *   Select one activity
    * */
    @GetMapping("/contentRead")
    public String getActivity(Model model,Integer acti_id) {

        // acti_id를 이용해 activity 한개를 조회
        ActivityAdminResponseDto activityDto = activityAdminService.getActivity(acti_id);
        System.out.println(activityDto);

        // activityDto를 View에 전달
        model.addAttribute("activityDto",activityDto);

        return "activity_list";
    }

    /*
    *   Modify activity page
    * */
    @GetMapping("/contentEdit")
    public String modifyActivity(Model model,Integer acti_id) throws ParseException {

        // 수정하려고 하는 활동터 게시글의 내용을 조회
        ActivityAdminResponseDto activityDto = activityAdminService.getActivity(acti_id);



        // 수정하려고 하는 활동터 게시글의 내용이 담긴 DTO를 View로 전달
        model.addAttribute("activityDto",activityDto);


        return "activity_modify";
    }

    /*
    *   Modify activity to database
    * */
    @PostMapping("/contentEdit")
    public String modifyActivity(ActivityAdminRequestDto activityDto, RedirectAttributes redirectAttributes){

        // DB에 Update를 수행
        int result = activityAdminService.modifyActivity(activityDto);
        System.out.println(result);

        /*
        *    Update 성공시 관리자 메인페이지로 이동
        *    Update 실패시 수정 페이지로 다시 이동하고, 업데이트에 실패했다는 경고메시지를 출력력
        * */
        if(result==1){
            return "common_admin";
        }else{
            redirectAttributes.addFlashAttribute("update_msg","업데이트에 실패했습니다.");
            return "activity_modify";
        }
    }

    /*
    *       Get Json Data From page
    * */
    @GetMapping("/contentAddJson")
    public String insertJson(){
        return "activity_json_test";
    }


}
