package com.routeinai.backend.profile.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ChangeProfile {
    private String profileImg;
    private String gender;
    private LocalDate birthDate;
    private Integer height;
}
