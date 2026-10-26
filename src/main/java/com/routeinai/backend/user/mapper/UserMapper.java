package com.routeinai.backend.user.mapper;

import com.routeinai.backend.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<User> findByUserId(Integer userId);
    Optional<User> findByExistUsername(String username);
    Optional<User> findByUsername(String username);
    void changeUsername(User user);
    void withdraw(Integer userId);

    Optional<User> findByProviderAndProviderUserId(User user);
    void insertUser(User user);

}
