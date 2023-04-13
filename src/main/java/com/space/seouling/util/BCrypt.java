package com.space.seouling.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCrypt {

    public String encodeBcrypt(String planeText) {
        return new BCryptPasswordEncoder(10).encode(planeText);
    }

    public boolean matchesBcrypt(String planeText, String hashValue) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(planeText, hashValue);
    }
}
