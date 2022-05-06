package com.slee.gateway.web.service;

import com.slee.gateway.handler.JwtTokenHandler;
import com.slee.gateway.handler.JwtTokenUtil;
import com.slee.gateway.web.model.core.CoreRequestDto;
import com.slee.gateway.web.model.token.CoreTokenRequestDto;
import com.slee.gateway.filter.common.TokenConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoreTokenService {

    @Value("${token.core.url}")
    private String coreUrl;
    private final JwtTokenHandler tokenHandler;
//    private final AccessTokenRepository accessTokenRepository;

    @PostConstruct
    public void init() throws Exception {
        executeIssue();
    }

    public void executeIssue() throws Exception {
        log.info("Token 재발급 EXECUTE!!!");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        CoreTokenRequestDto requestDto = CoreTokenRequestDto.builder().instCd("0000").userId("ONEQSCG").password("1").url("").build();

        try {
            HttpEntity<String> response = restTemplate.exchange(
                    new URI(coreUrl)
                    , HttpMethod.POST
                    , new HttpEntity<>(CoreRequestDto.builder().input(requestDto).build(), headers)
                    , String.class);

            String bearerToken = response.getHeaders().get(TokenConstants.HEADER_AUTH_TOKEN_KEY).get(0).substring(7);
            long exp = JwtTokenUtil.getExpiration(bearerToken);

            log.info("Key={" + TokenConstants.TARGET_KEY_CORE + "}, exp={" + exp + "}, value={" + bearerToken + "}");

//        accessTokenRepository.save(AccessToken.builder().key(target).exp(exp).value(bearerToken).use("Y").build());
            tokenHandler.setToken(TokenConstants.TARGET_KEY_CORE, bearerToken);

            log.info("Token Issue Success!!");
        } catch(RestClientException exception) {
            log.error("Token 발급 요청 중 에러 발생!!", exception);
        }
    }
}
