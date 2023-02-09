package com.pgrrr.woohaha.mapper;

import com.pgrrr.woohaha.user.domain.User;
import com.pgrrr.woohaha.user.dto.UserResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    Integer save(User user);
    User findByEmail(String user_email);
    User findById(Integer user_id);
    List<UserResponseDto> findCouponById(Integer user_id);
    Integer update(User User);
    Integer updatePnt(@Param("user_id") Integer user_id, @Param("pnt") Integer pnt);
    Integer updateCoupon(@Param("user_id") Integer user_id, @Param("coupn_id") Integer coupn_id);
    Integer delete(Integer user_id);
    
}
