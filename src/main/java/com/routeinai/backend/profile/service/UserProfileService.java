package com.routeinai.backend.profile.service;

import com.routeinai.backend.profile.dto.request.ChangeProfile;
import com.routeinai.backend.profile.entity.UserProfile;
import com.routeinai.backend.profile.mapper.UserProfileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileMapper userProfileMapper;
    public UserProfile getProfileByUserId(Integer userId) {
        return userProfileMapper.findByUserId(userId).orElseThrow(() -> new RuntimeException("해당 유저의 프로필이 존재하지 않습니다."));

    }

    public UserProfile changeProfile(Integer userId, ChangeProfile changeProfile) {

        UserProfile profile = UserProfile.builder()
                .userId(userId)
                .profileImg(changeProfile.getProfileImg())
                .gender(changeProfile.getGender())
                .birthDate(changeProfile.getBirthDate())
                .height(changeProfile.getHeight())
                .build();

        boolean exist = userProfileMapper.findByUserId(userId).isPresent();

        if(exist) {
            userProfileMapper.updateProfile(profile);
        }  else {
            userProfileMapper.insertProfile(profile);
        }
        return userProfileMapper.findByUserId(userId).orElseThrow(() -> new RuntimeException("프로필 조회에 실패했습니다."));

    }
}
