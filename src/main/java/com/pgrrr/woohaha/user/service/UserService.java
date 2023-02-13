package com.pgrrr.woohaha.user.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pgrrr.woohaha.mapper.UserMapper;
import com.pgrrr.woohaha.user.domain.User;
import com.pgrrr.woohaha.user.dto.UserJoinRequestDto;
import com.pgrrr.woohaha.user.dto.UserLoginRequestDto;
import com.pgrrr.woohaha.user.dto.UserResponseDto;
import com.pgrrr.woohaha.util.EncryptSha256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
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

    public UserResponseDto modifyMember(UserJoinRequestDto updateRequest) {
        User user = Optional.ofNullable(userMapper.findByEmail(updateRequest.getEmail())).orElseThrow(() -> new NullPointerException("존재하지 않는 회원 입니다."));
        updateRequest.setId(user.getId());
        updateRequest.setPwd(EncryptSha256.encrypt(updateRequest.getPwd()));
        userMapper.update(updateRequest.toEntity());
        return new UserResponseDto(user);
    }

    public String getAccessToken(String authorize_code) {
        String access_token = "";
        String refresh_token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=7ab07adcdacec7c4752add19a162ee1b");
            sb.append("&redirect_uri=http://localhost:8080/members/kakao");
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            int responseCode = conn.getResponseCode();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();


            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return access_token;
    }

    public HashMap<String, Object> getUserInfo(String access_Token) {

        HashMap<String, Object> userInfo = new HashMap<String, Object>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            long id = element.getAsJsonObject().get("id").getAsLong();
            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();
//            String age = kakao_account.getAsJsonObject().get("age_range").getAsString();
            String gender = kakao_account.getAsJsonObject().get("gender").getAsString();

            userInfo.put("nickname", nickname);
            userInfo.put("email", email);
//            userInfo.put("age", age);
            userInfo.put("id", id);
            userInfo.put("gender", gender);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}
