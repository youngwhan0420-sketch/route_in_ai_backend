package com.routeinai.backend.attendance.controller;

import com.routeinai.backend.attendance.entity.Attendance;
import com.routeinai.backend.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping("/today/{userId}")
    public ResponseEntity<Attendance> attendance(@PathVariable Integer userId) {
        Attendance attendance = attendanceService.attendance(userId);
        return ResponseEntity.ok(attendance);
    }

    @GetMapping("/today/attendance/{userId}")
    public ResponseEntity<Boolean> todayAttendance(@PathVariable Integer userId) {
        boolean exist = attendanceService.todayAttendance(userId);
        return ResponseEntity.ok(exist);
    }

    @GetMapping("/all/attendance/{userId}")
    public ResponseEntity<List<Attendance>> allAttendance(@PathVariable Integer userId) {
        List<Attendance> attendanceList = attendanceService.allAttendance(userId);
        return ResponseEntity.ok(attendanceList);
    }
}
