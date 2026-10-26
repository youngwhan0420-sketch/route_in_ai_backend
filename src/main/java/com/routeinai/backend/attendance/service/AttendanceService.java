package com.routeinai.backend.attendance.service;

import com.routeinai.backend.attendance.entity.Attendance;
import com.routeinai.backend.attendance.mapper.AttendanceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceMapper attendanceMapper;

    public Attendance attendance(Integer userId) {
        Attendance attendance = Attendance.builder()
                .userId(userId)
                .attendanceDate(LocalDate.now())
                .build();
        boolean exist = attendanceMapper.findByUserIdAttendance(attendance).isPresent();

        if(exist) {
            throw new RuntimeException("이미 오늘 출석했습니다.");
        }
        attendanceMapper.insertAttendance(attendance);
        return attendanceMapper.findByUserIdAttendance(attendance).orElseThrow(()
                -> new RuntimeException("출석 정보 조회에 실패했습니다."));
    }
    public boolean todayAttendance(Integer userId) {
        Attendance todayExist = Attendance.builder()
                .userId(userId)
                .attendanceDate(LocalDate.now())
                .build();

        return attendanceMapper.findByUserIdAttendance(todayExist).isPresent();

    }
    public List<Attendance> allAttendance(Integer userId) {
        return attendanceMapper.findByUserIdAllAttendance(userId);

    }
}
