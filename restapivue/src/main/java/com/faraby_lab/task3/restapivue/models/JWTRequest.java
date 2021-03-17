package com.faraby_lab.task3.restapivue.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTRequest implements Serializable {

    private static final Long serialVersionUID = 123456789L;
    private String email;
    private String password;
}
