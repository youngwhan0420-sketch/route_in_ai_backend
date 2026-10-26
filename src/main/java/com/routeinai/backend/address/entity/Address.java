package com.routeinai.backend.address.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Address {
    private Integer userId;
    private String zipCode;
    private String baseAddress;
    private String detailAddress;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
}
