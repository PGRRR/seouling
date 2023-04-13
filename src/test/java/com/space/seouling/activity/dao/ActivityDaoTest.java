package com.space.seouling.activity.dao;

import com.space.seouling.activity.controller.ActivityController;
import com.space.seouling.activity.dto.ActivityAdminRequestDto;
import com.space.seouling.activity.dto.ActivityRequestDto;
import com.space.seouling.activity.service.ActivityService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ActivityDaoTest {

    @Mock
    private ActivityController activityController;

    @InjectMocks
    private ActivityService activityService;

    @Test
    @DisplayName("활동터 조회 성공")
    void findAct() {
        //given
        ActivityRequestDto activityRequestDto = new ActivityRequestDto();
        Mockito.doReturn(null).when(activityService).viewAct(activityRequestDto);
//        Mockito.doReturn().when(activityDao)
    }

    private ActivityRequestDto activityRequestDto() {
        ActivityRequestDto activityRequestDto = new ActivityRequestDto();
        activityRequestDto.setActi_cd("A01");
        activityRequestDto.setSize(8);
        activityRequestDto.setSort("from,desc");
        return activityRequestDto;
    }

    @Test
    @DisplayName("지역별 개수 조회 성공")
    void addrCount() {
        //given
        String addr = "";
        Mockito.lenient().doReturn(0).when(activityService).countLocation(addr);
    }
}