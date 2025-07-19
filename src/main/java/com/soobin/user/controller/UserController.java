package com.soobin.user.controller;

import com.soobin.user.dto.UserSignupRequest;
import com.soobin.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입 API
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserSignupRequest request) {
        userService.registerUser(request);
        return ResponseEntity.ok("회원가입 성공");
    }

    // 로그인 후 내 정보 조회 API
    @GetMapping("/me")
    public ResponseEntity<?> getMyInfo(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }

        var userInfo = userService.getUserInfo(userDetails.getUsername());

        return ResponseEntity.ok(userInfo);
    }
}
