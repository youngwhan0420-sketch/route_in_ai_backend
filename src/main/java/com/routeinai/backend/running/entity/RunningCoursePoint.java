package com.routeinai.backend.running.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class RunningCoursePoint {
    private Integer coursePointId;
    private Integer courseId;
    private Integer pointOrder;
    private BigDecimal latitude;
    private BigDecimal longitude;

}
