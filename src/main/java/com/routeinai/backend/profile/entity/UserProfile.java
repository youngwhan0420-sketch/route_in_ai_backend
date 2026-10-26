package com.routeinai.backend.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile {
    private Integer userId;
    private String profileImg;
    private String gender;
    private LocalDate birthDate;
    private Integer height;
    private LocalDateTime updateDt;
}
