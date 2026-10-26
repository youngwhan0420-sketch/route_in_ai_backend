package com.routeinai.backend.running.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
public class RunningRecord {
    private Integer runningRecordId;
    private Integer userId;
    private BigDecimal distanceKm;
    private Integer calories;
    private LocalDateTime startedDt;
    private LocalDateTime endedDt;
    private LocalDateTime createDt;

}
