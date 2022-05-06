package com.slee.gateway.web.controller;

import com.slee.gateway.web.service.CoreTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/token")
public class TokenController {
    private final CoreTokenService coreTokenService;

    @PostMapping(value = "core/issue")
    public ResponseEntity<?> tokenIssue() throws Exception {
        coreTokenService.executeIssue();
        return ResponseEntity.ok("Success!!");
    }
}
