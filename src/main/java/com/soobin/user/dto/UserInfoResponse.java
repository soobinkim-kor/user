package com.soobin.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoResponse {
    private String account;
    private String name;
    private String topRegion;  // 예: "서울특별시"
}
