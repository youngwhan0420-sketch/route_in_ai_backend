package com.routeinai.backend.inbody.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InBody {
    private Integer measurementId;
    private Integer userId;

    private BigDecimal weight;
    private BigDecimal skeletalMuscleMass;
    private BigDecimal bodyFatMass;

    private LocalDateTime measuredDt;
    private LocalDateTime createDt;
}
