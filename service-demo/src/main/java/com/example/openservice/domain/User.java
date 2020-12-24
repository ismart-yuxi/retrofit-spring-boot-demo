package com.example.openservice.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User extends com.example.openservice.domain.Base implements Serializable {

    private String username;
    private int age;
    private String password;
}
