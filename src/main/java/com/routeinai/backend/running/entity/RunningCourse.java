package com.routeinai.backend.running.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RunningCourse {
    private Integer courseId;
    private Integer userId;
    private String courseName;
    private BigDecimal distanceKm;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
}
