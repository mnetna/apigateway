package com.slee.gateway.jpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
//@Table(name = "access_token")
//@IdClass(AccessTokenPK.class)
//@Entity
public class AccessToken {

//    @Id
    private String key;
//    @Id
    private long exp;
    private String value;
    private String use;

    @Builder
    public AccessToken(String key, long exp, String value, String use) {
        this.key = key;
        this.exp = exp;
        this.value = value;
        this.use = use;
    }
}

