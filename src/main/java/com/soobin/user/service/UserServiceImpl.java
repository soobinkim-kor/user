package com.soobin.user.service;

import com.soobin.user.dto.UserInfoResponse;
import com.soobin.user.dto.UserSignupRequest;
import com.soobin.user.repository.UserRepository;
import com.soobin.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserSignupRequest request) {
        if (userRepository.existsByAccount(request.getAccount())) {
            throw new IllegalArgumentException("중복된 계정입니다.");
        }
        if (userRepository.existsByRrn(request.getRrn())) {
            throw new IllegalArgumentException("중복된 주민등록번호입니다.");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        UserEntity user = UserEntity.builder()
                .account(request.getAccount())
                .password(encodedPassword)
                .name(request.getName())
                .rrn(request.getRrn())
                .phone(request.getPhone())
                .address(request.getAddress())
                .build();

        userRepository.save(user);
    }

    @Override
    public UserInfoResponse getUserInfo(String account) {
        UserEntity user = userRepository.findByAccount(account)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        String topRegion = extractTopRegion(user.getAddress());

        return new UserInfoResponse(user.getAccount(), user.getName(), topRegion);
    }

    @Override
    public String extractTopRegion(String address) {
        // 예시: 공백 기준으로 첫 단어만 반환
        if (address == null || address.isBlank()){
            return "";
        }
        return address.split(" ")[0];
    }
}
