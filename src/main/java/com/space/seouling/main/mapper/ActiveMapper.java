package com.space.seouling.main.mapper;

import com.space.seouling.main.domain.TempActive;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActiveMapper {
    Integer save(TempActive tempActive);

    List<TempActive> findList();

    List<TempActive> findByIdList(List<Integer> activeList);

    Integer update(TempActive tempActive);

    Integer delete(Integer activeId);
}
