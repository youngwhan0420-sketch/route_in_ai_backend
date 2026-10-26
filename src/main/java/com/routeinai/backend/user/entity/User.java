package com.routeinai.backend.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer userId;
    private String username;
    private String provider;
    private String providerUserId;
    private String status;
    private String role;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
    private LocalDateTime withdrawDt;
    private LocalDateTime deleteDt;

}
