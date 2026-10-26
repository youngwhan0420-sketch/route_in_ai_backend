package com.routeinai.backend.follow.mapper;

import com.routeinai.backend.follow.entity.Follow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FollowMapper {
    Optional<Follow> findByFollowerAndFollowing(Follow follow);
    void insertFollow(Follow follow);
    void deleteFollow(Follow follow);
    List<Follow> findFollowerListByUserId(Integer userId);
    List<Follow> findFollowingListByUserId(Integer userId);
}
