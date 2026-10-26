package com.routeinai.backend.running.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CreateRunningCoursePoint {
    private Integer pointOrder;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
