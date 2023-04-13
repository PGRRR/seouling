package com.space.seouling.stamp.service;

import com.space.seouling.stamp.dao.StampDao;
import com.space.seouling.stamp.dto.StampRequestDto;
import com.space.seouling.stamp.dto.StampResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StampService {

    private final StampDao stampDao;


    public Integer addStamp(StampRequestDto requestDto) {
        String user_id = requestDto.getUser_id();
        Integer count = stampDao.count(user_id);
        Integer seq = stampDao.findLastSeqByUserId(user_id);
        if (count >= 10) {
            stampDao.deleteLastOne(user_id);
        }
        if (Optional.ofNullable(seq).isEmpty()) {
            requestDto.setSeq(1);
        } else {
            requestDto.setSeq(seq + 1);
        }
        return stampDao.save(requestDto);
    }
    @Transactional(readOnly = true)
    public List<StampResponseDto> viewStampList(String userId) {
        return stampDao.findByUserId(userId);
    }

    /**
     * temp
     */
    public Integer modifyStampSeq(StampRequestDto requestDto) {
        return stampDao.update(requestDto);
    }

    public Integer removeStamp(StampRequestDto requestDto) {
        return stampDao.delete(requestDto);
    }

}
