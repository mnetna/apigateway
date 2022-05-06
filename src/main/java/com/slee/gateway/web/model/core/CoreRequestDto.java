package com.slee.gateway.web.model.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slee.gateway.web.model.common.SystemInfo;
import com.slee.gateway.web.model.common.SystemInfoConstants;
import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoreRequestDto {
    @JsonProperty("input")
    private Object input;
    @JsonProperty("SysInfo")
    @Builder.Default
    private SystemInfo sysInfo =
            SystemInfo.builder()
                    .chnlTypCd(SystemInfoConstants.SYSINFO_CHNL_TYPE_CD_IBT)
                    .userId(SystemInfoConstants.SYSINFO_USER_ID_SCG)
                    .build();
}
