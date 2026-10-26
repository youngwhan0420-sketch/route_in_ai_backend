package com.routeinai.backend.running.controller;


import com.routeinai.backend.running.service.RunningRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/runningrecord/")
@RequiredArgsConstructor
public class RunningRecordController {
    private final RunningRecordService runningRecordService;


}
