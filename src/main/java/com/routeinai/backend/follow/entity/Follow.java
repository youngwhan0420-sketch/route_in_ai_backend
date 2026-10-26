package com.routeinai.backend.follow.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    private Integer followId;
    private Integer followerUserId;
    private Integer followingUserId;
    private LocalDateTime createDt;

}
