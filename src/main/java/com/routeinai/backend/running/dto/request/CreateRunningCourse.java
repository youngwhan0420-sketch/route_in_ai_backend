package com.routeinai.backend.running.dto.request;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
public class CreateRunningCourse {
    private String courseName;
    private BigDecimal distanceKm;
    private List<CreateRunningCoursePoint> points;


}