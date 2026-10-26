package com.routeinai.backend.profile.controller;

import com.routeinai.backend.profile.dto.request.ChangeProfile;
import com.routeinai.backend.profile.entity.UserProfile;
import com.routeinai.backend.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UserProfileService userProfileService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfile> getProfile(
            @PathVariable Integer userId
    ) {
        UserProfile profile = userProfileService.getProfileByUserId(userId);

        return ResponseEntity.ok(profile);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserProfile> changeProfile(
            @PathVariable Integer userId, @RequestBody ChangeProfile changeProfile
            ) {
        UserProfile profile = userProfileService.changeProfile(userId, changeProfile);

        return ResponseEntity.ok(profile);
    }
}
