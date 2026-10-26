package com.routeinai.backend.profile.mapper;

import com.routeinai.backend.profile.entity.UserProfile;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper

public interface UserProfileMapper {
    Optional<UserProfile> findByUserId(Integer userId);
    void updateProfile(UserProfile profile);
    void insertProfile(UserProfile profile);
}
