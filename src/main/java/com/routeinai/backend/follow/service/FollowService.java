package com.routeinai.backend.follow.service;

import com.routeinai.backend.follow.entity.Follow;
import com.routeinai.backend.follow.mapper.FollowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowMapper followMapper;

    public Follow follow(Integer followerUserId, Integer followingUserId) {
        if (followerUserId.equals(followingUserId)) {
            throw new RuntimeException("자기 자신을 팔로우할 수 없습니다.");
        }
        Follow follow = Follow.builder()
                .followerUserId(followerUserId)
                .followingUserId(followingUserId)
                .build();

        boolean exist = followMapper.findByFollowerAndFollowing(follow).isPresent();

        if(exist) {
            throw new RuntimeException("이미 팔로우 중입니다.");
        }
        followMapper.insertFollow(follow);

        return followMapper.findByFollowerAndFollowing(follow).orElseThrow(() -> new RuntimeException("팔로우 정보 조회에 실패했습니다."));
    }

    public void unfollow (
            Integer followerUserId, Integer followingUserId) {
            Follow unfollow = Follow.builder()
                    .followerUserId(followerUserId)
                    .followingUserId(followingUserId)
                    .build();

            boolean exist = followMapper.findByFollowerAndFollowing(unfollow).isPresent();

            if (!exist) {
                throw new RuntimeException("팔로우 관계가 존재하지 않습니다.");
            }
            followMapper.deleteFollow(unfollow);
    }

    public boolean isFollowing(Integer followerUserId,
                               Integer followingUserId) {
        Follow followExist = Follow.builder()
                .followerUserId(followerUserId)
                .followingUserId(followingUserId)
                .build();

        return followMapper.findByFollowerAndFollowing(followExist).isPresent();
    }

    public List<Follow> followerList(Integer userId) {
        return followMapper.findFollowerListByUserId(userId);
    }

    public List<Follow> followingList(Integer userId) {
        return followMapper.findFollowingListByUserId(userId);
    }







}
