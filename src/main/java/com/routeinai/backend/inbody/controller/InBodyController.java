package com.routeinai.backend.inbody.controller;

import com.routeinai.backend.inbody.dto.request.CreateInBody;
import com.routeinai.backend.inbody.entity.InBody;
import com.routeinai.backend.inbody.service.InBodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inbody")
public class InBodyController {
    private final InBodyService inBodyService;

    @PostMapping("/{userId}")
    public ResponseEntity<InBody> createInBody(
            @PathVariable Integer userId, @RequestBody CreateInBody createInBody
    ) {
        InBody inBody = inBodyService.createInBody(userId, createInBody);

        return ResponseEntity.ok(inBody);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<InBody>> getInBody (
            @PathVariable Integer userId
    ) {
        List<InBody> inBodyList = inBodyService.getInBody(userId);

        return ResponseEntity.ok(inBodyList);
    }

    @GetMapping("/recent/{userId}")
    public ResponseEntity<InBody> getRecentInBody (
            @PathVariable Integer userId
    ) {
        InBody inBody = inBodyService.getRecentInBody(userId);

        return ResponseEntity.ok(inBody);
    }
}
