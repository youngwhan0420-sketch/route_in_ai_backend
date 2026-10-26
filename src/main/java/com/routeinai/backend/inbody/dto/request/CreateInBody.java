package com.routeinai.backend.inbody.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CreateInBody {
    private BigDecimal weight;
    private BigDecimal skeletalMuscleMass;
    private BigDecimal bodyFatMass;
    private LocalDateTime measuredDt;

}
