package com.routeinai.backend.running.controller;


import com.routeinai.backend.running.entity.RunningCourse;
import com.routeinai.backend.running.service.RunningCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/runningcourse/")
@RequiredArgsConstructor
public class RunningCourseController {
    private final RunningCourseService runningCourseService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<RunningCourse> createRunningCourse(@PathVariable Integer userId,
                                                             @RequestBody Create)

    @GetMapping("/one/{courseId}")


    @GetMapping("/user/{userId}")

    @PutMapping("/update/{courseId}")

    @DeleteMapping("/delete/{courseId}")

}
