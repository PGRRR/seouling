package com.pgrrr.woohaha.user.service;

import com.pgrrr.woohaha.mapper.UserMapper;
import com.pgrrr.woohaha.user.domain.User;
import com.pgrrr.woohaha.user.dto.UserJoinRequestDto;
import com.pgrrr.woohaha.user.dto.UserLoginRequestDto;
import com.pgrrr.woohaha.user.dto.UserResponseDto;
import com.pgrrr.woohaha.util.EncryptSha256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Integer join(UserJoinRequestDto requestDto) {
        Optional.ofNullable(userMapper.findByEmail(requestDto.getEmail()))
                .ifPresent((user -> {
                    throw new RuntimeException();/**/
                }));
        requestDto.setPwd(EncryptSha256.encrypt(requestDto.getPwd()));
        return userMapper.save(requestDto.toEntity());
    }

    public UserResponseDto login(UserLoginRequestDto requestDto) {
        User user = Optional.ofNullable(userMapper.findByEmail(requestDto.getEmail())).orElseThrow(RuntimeException::new);/**/
        String encryptPassword = EncryptSha256.encrypt(requestDto.getPwd());
        if (encryptPassword.equals(user.getPwd())) {
            throw new RuntimeException();/**/
        }
        return new UserResponseDto(user);
    }
}
