package com.space.seouling.activity.service;

import com.space.seouling.activity.dao.ActivityAdminDao;
import com.space.seouling.activity.dto.ActivityAdminRequestDto;
import com.space.seouling.activity.dto.ActivityAdminResponseDto;
import com.space.seouling.activity.dto.PageHandler;
import com.space.seouling.activity.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ActivityAdminService{

    private final ActivityAdminDao activityAdminDao;


    public int addActivity(ActivityAdminRequestDto ActivityAdminRequestDto) {
        return activityAdminDao.insertActivity(ActivityAdminRequestDto);
    }

    public List<ActivityAdminResponseDto> getAllActivity() {
        List<ActivityAdminResponseDto> list = activityAdminDao.selectAllActivity();

        if(list.isEmpty()){
            throw new CustomException(ErrorCodeList.FAIL_TO_GET_ACTIVITY_LIST_EXCEPTION);
        }else{
            return list;
        }
    }

    public int deleteActivity(Integer acti_id) {
        return activityAdminDao.deleteActivity(acti_id);
    }

    public int modifyActivity(ActivityAdminRequestDto ActivityAdminRequestDto) {
        return activityAdminDao.updateActivity(ActivityAdminRequestDto);
    }

    public ActivityAdminResponseDto getActivity(Integer acti_id) {
        ActivityAdminResponseDto activityAdminResponseDto = activityAdminDao.selectActivity(acti_id);

        if(activityAdminResponseDto==null){
            throw new CustomException(ErrorCodeList.FAIL_TO_GET_ACTIVITY_EXCEPTION);
        }else{
            return activityAdminResponseDto;
        }
    }

    public int getActivityCnt() {
        return activityAdminDao.selectActivityCnt();
    }

    public int modifyActivityState(Map map) {
        return activityAdminDao.updateActivityState(map);
    }

    public ActivityAdminResponseDto getActivityTitle(String ttl) {
        return activityAdminDao.selectActivityTitle(ttl);
    }
}
