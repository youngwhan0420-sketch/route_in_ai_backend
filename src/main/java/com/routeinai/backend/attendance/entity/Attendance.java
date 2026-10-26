package com.routeinai.backend.attendance.entity;

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
public class Attendance {
    private Integer attendanceId;
    private Integer userId;
    private LocalDate attendanceDate;
    private Boolean popupShown;
    private LocalDateTime createDt;
}
