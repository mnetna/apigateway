package com.slee.gateway.jpa.entity;

import java.io.Serializable;

public class AccessTokenPK implements Serializable {
    private String key;
    private long exp;
}
