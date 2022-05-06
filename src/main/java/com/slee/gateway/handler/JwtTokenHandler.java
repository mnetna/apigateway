package com.slee.gateway.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class JwtTokenHandler {
//    private Map<String, LinkedList<TokenDto>> tokenMap = new HashMap<>();
    private Map<String, String> tokenMap = new HashMap<>();

    //    public LinkedList<TokenDto> getTokenListByKey(String key) {
//        return tokenMap.get(key);
//    }

    public String getTokenByKey(String key) {
        return tokenMap.get(key);
    }

    public void setToken(String key, String token) {
        tokenMap.put(key, token);
    }
}
