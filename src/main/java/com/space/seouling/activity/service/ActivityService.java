package com.space.seouling.activity.service;

import com.space.seouling.activity.dao.ActivityDao;
import com.space.seouling.activity.dto.ActivityRequestDto;
import com.space.seouling.activity.domain.Activity;
import com.space.seouling.activity.dto.ActivityResponseDto;
import com.space.seouling.activity.exception.EmptyListException;
import com.space.seouling.global.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityDao activityDao;

    public List<ActivityResponseDto> viewAct(ActivityRequestDto activityRequestDto) {
        List<ActivityResponseDto> actList = activityDao.findAct(activityRequestDto);
        if (actList.isEmpty()) {
            throw new EmptyListException("빈 활동터 리스트", ErrorCode.EMPTY_FAIL);
        }
        return actList;
    }

    @Transactional
    public List<ActivityResponseDto> viewStamp(List<Integer> seq) {
        List<ActivityResponseDto> actList = new ArrayList<>();
        for (Integer integer : seq) {
            ActivityResponseDto stamp = activityDao.findStamp(integer);
            if (stamp != null) {
                actList.add(stamp);
            } else {
                throw new EmptyListException("비어있는 활동터 입니다.", ErrorCode.EMPTY_FAIL);
            }
        }
        return actList;
    }

    @Transactional
    public Integer saveAct(List<Activity> activityList) {
        int count = 0;
        for (Activity activity : activityList) {
            Integer saveAct = activityDao.saveAct(activity);
            count += saveAct;
        }
        return count;
    }

    public Integer countLocation(String addr) {
        return activityDao.addrCount(addr);
    }
}
