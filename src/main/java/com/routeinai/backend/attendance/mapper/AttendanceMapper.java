package com.routeinai.backend.attendance.mapper;

import com.routeinai.backend.attendance.entity.Attendance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AttendanceMapper {
    Optional<Attendance> findByUserIdAttendance(Attendance attendance);
    void insertAttendance(Attendance attendance);
    List<Attendance> findByUserIdAllAttendance(Integer userId);
}
