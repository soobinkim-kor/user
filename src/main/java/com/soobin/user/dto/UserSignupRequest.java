package com.soobin.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupRequest {
    private String account;
    private String password;
    private String name;
    private String rrn;
    private String phone;
    private String address;
}
