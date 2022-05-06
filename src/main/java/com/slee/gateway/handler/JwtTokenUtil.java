package com.slee.gateway.handler;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;

import java.util.Date;

@Slf4j
public class JwtTokenUtil {

    public static boolean isExpire(String token) {
        long now = (new Date()).getTime() / 1000;
        long exp = JwtTokenUtil.getExpiration(token);
        if (now > exp) {
            return true;
        }
        return false;
    }

    public static long getExpiration(String token) {
        String payload = token.split("\\.")[1];
        byte[] payloadDecode = Base64Utils.decodeFromString(payload);
        JsonObject payloadJson =  (JsonObject) new JsonParser().parse(new String(payloadDecode));
        long exp = payloadJson.get("exp").getAsLong();
        return exp;
    }
}
