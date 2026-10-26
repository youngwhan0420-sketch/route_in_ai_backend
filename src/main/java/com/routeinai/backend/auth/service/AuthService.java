package com.routeinai.backend.auth.service;

import com.routeinai.backend.auth.dto.request.SignupRequest;
import com.routeinai.backend.user.entity.User;
import com.routeinai.backend.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserMapper userMapper;

    public void signup(SignupRequest signupRequest) {
        boolean usernameExist = userMapper.findByExistUsername(signupRequest.getUsername()).isPresent();

        if(usernameExist) {
            throw new RuntimeException("이미 사용중인 username입니다.");
        }
        User user = User.builder()
                .username(signupRequest.getUsername())
                .provider(signupRequest.getProvider())
                .providerUserId(signupRequest.getProviderUserId())
                .build();

        boolean providerExist = userMapper.findByProviderAndProviderUserId(user).isPresent();

        if(providerExist) {
            throw new RuntimeException("이미 가입된 계정입니다.");
        }
        userMapper.insertUser(user);
    }
}
