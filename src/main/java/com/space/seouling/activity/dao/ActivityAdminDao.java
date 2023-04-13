package com.space.seouling.activity.dao;

import com.space.seouling.activity.dto.ActivityAdminRequestDto;
import com.space.seouling.activity.dto.ActivityAdminResponseDto;
import com.space.seouling.activity.dto.PageHandler;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ActivityAdminDao {

    int insertActivity(ActivityAdminRequestDto activityDto);
    List<ActivityAdminResponseDto> selectAllActivity();
    int deleteActivity(Integer acti_id);
    int updateActivity(ActivityAdminRequestDto activityDto);
    ActivityAdminResponseDto selectActivity(Integer acti_id);
    int selectActivityCnt();
    int updateActivityState(Map map);
    ActivityAdminResponseDto selectActivityTitle(String ttl);

}
