package com.routeinai.backend.user.service;

import com.routeinai.backend.user.entity.User;
import com.routeinai.backend.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    // userId로 조회하기
    public User getUserById(Integer userId) {
        return userMapper.findByUserId(userId).orElseThrow(() -> new RuntimeException("해당 유저가 존재하지 않습니다."));

    }

    // 중복 username 조회하기
    public boolean getUserExistByUsername(String username) {
        return userMapper.findByExistUsername(username).isPresent();

    }

    // username로 조회하기
    public User getUserByUsername(String username) {
        return userMapper.findByUsername(username).orElseThrow(() -> new RuntimeException("해당 유저가 존재하지 않습니다."));

    }

    // username 변경하기
    public void getUserByChangeUsername(Integer userId, String username) {
        boolean exist = userMapper.findByExistUsername(username).isPresent();

        if (exist) {
            throw new RuntimeException("이미 사용중인 username입니다.");
        }
        User user = User.builder()
                .userId(userId)
                .username(username)
                .build();

        userMapper.changeUsername(user);
    }
    // 탈퇴하기
    public void withdraw(Integer userId) {
        userMapper.findByUserId(userId).orElseThrow(() -> new RuntimeException("해당 유저가 존재하지 않습니다."));
        userMapper.withdraw(userId);

    }

}
