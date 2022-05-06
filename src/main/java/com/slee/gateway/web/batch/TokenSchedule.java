package com.slee.gateway.web.batch;

import com.slee.gateway.web.service.CoreTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenSchedule {

    private final CoreTokenService coreTokenService;

    @Scheduled(cron = "${token.core.cron}")
    public void executeIssueByCore() throws Exception {
        coreTokenService.executeIssue();
    }
}
