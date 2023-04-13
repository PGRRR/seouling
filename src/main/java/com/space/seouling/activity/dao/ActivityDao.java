package com.space.seouling.activity.dao;

import com.space.seouling.activity.domain.Activity;
import com.space.seouling.activity.dto.ActivityAdminRequestDto;
import com.space.seouling.activity.dto.ActivityRequestDto;
import com.space.seouling.activity.dto.ActivityResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityDao {
    List<ActivityResponseDto> findAct(ActivityRequestDto activityRequestDto);

    ActivityResponseDto findStamp(Integer seq);

    Integer addrCount(String addr);

    Integer saveAct(Activity activity);

}
