package com.routeinai.backend.follow.controller;

import com.routeinai.backend.follow.entity.Follow;
import com.routeinai.backend.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {
    private final FollowService followService;

    @PostMapping("/{followerUserId}/{followingUserId}")
    public ResponseEntity<Follow> follow(
            @PathVariable Integer followerUserId,
            @PathVariable Integer followingUserId) {
        Follow follow = followService.follow(followerUserId, followingUserId);

        return ResponseEntity.ok(follow);
    }
    @DeleteMapping("/{followerUserId}/{followingUserId}")
    public ResponseEntity<Void> unfollow(
            @PathVariable Integer followerUserId,
            @PathVariable Integer followingUserId) {
        followService.unfollow(followerUserId, followingUserId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{followerUserId}/{followingUserId}/exist")
    public ResponseEntity<Boolean> followList(
            @PathVariable Integer followerUserId,
            @PathVariable Integer followingUserId
    ) {
        boolean exist = followService.isFollowing(followerUserId, followingUserId);
        return ResponseEntity.ok(exist);
    }

    @GetMapping("/followers/{userId}")
    public ResponseEntity<List<Follow>> followerList (@PathVariable Integer userId) {
        List<Follow> followers = followService.followerList(userId);
        return ResponseEntity.ok(followers);
    }

    @GetMapping("/followings/{userId}")
    public ResponseEntity<List<Follow>> followingList(@PathVariable Integer userId) {
        List<Follow> followings = followService.followingList(userId);
        return ResponseEntity.ok(followings);
    }
}
