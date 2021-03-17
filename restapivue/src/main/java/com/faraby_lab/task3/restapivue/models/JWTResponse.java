package com.faraby_lab.task3.restapivue.models;

import java.io.Serializable;

public class JWTResponse implements Serializable {

    private static final Long serialVersionUID = 987654321L;
    private final String jwtToken;

    public JWTResponse(String jwtToken){
        this.jwtToken = jwtToken;
    }

    public String getJwtToken(){
        return this.jwtToken;
    }
}
