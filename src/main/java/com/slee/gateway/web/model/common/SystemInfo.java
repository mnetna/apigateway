package com.slee.gateway.web.model.common;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemInfo {
    private String instCd;
    private String acBrNo;
    private String baseCurCd;
    private String bussBrUpdAlwnYn;
    private String cntyCd;
    private String dtFrmt;
    private String dtMarkFrmt;
    private String globId;
    private String istBrNo;
    private String logLev;
    private String rsprApvAlwnYn;
    private String rsprApvYn;
    private String rsprTrscGlobId;
    private String rsprMngrId;
    private String scrnId;
    private String smltnTrscYn;
    private String subjCd;
    private String sysDvCd;
    private String sysLnggCd;
    private String tmlNo;
    private String trscBrNo;
    private String trscDt;
    private String bussDt;
    private String usrNm ;
    private String rcknDt;
    private String trscCd;
    private String procSvcCd;
    private String wsDemnIpAdr;
    private String wsDemnPort;
    private String ipAddr;
    private String lnkIndvCanYn;
    private String scrnMsgPrnYn;
    private String rsprApvCreYn;
    private String lnggCd;
    private String rsprApvDvCd;
    private String certsNo;
    private String testGlobId;
    private String pwStCd;
    private String chnlTypCd;
    private String userId;

    @Builder
    public SystemInfo(String chnlTypCd, String userId) {
        this.chnlTypCd = chnlTypCd;
        this.userId = userId;
    }
}
