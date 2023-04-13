package com.space.seouling.main.service;

import com.space.seouling.main.domain.TempActive;
import com.space.seouling.main.dto.TempActiveResponseDto;
import com.space.seouling.main.exception.ActiveException;
import com.space.seouling.main.mapper.ActiveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ActiveService {

    private final ActiveMapper activeMapper;

    public List<TempActive> viewActiveList(List<Integer> activeList) {
        if (activeList.isEmpty()) {
            throw new ActiveException("비어 있는 활동 리스트");
        }
       return activeMapper.findByIdList(activeList);
    }

    public List<TempActiveResponseDto> viewActiveList() {
        return activeMapper.findList().stream()
                .map(TempActive::toResponseDto)
                .collect(Collectors.toList());
    }

    public Integer addActive(TempActive tempActive) {
        return activeMapper.save(tempActive);
    }
}
