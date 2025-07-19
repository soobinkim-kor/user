package com.soobin.user.service;

import com.soobin.user.dto.UserInfoResponse;
import com.soobin.user.dto.UserSignupRequest;

public interface UserService {
    void registerUser(UserSignupRequest request);
    UserInfoResponse getUserInfo(String account);
    String extractTopRegion(String address);
}
