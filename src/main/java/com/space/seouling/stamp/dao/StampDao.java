package com.space.seouling.stamp.dao;

import com.space.seouling.stamp.dto.StampResponseDto;
import com.space.seouling.stamp.dto.StampRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StampDao {

    Integer save(StampRequestDto requestDto);

    List<StampResponseDto> findByUserId(String userId);

    Integer update(StampRequestDto requestDto);

    Integer delete(StampRequestDto requestDto);

    Integer count(String userId);

    Integer deleteLastOne(String userId);

    Integer findLastSeqByUserId(String userId);
}
