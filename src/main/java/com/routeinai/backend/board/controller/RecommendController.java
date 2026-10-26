package com.routeinai.backend.board.controller;


import com.routeinai.backend.board.entity.Recommend;

import com.routeinai.backend.board.service.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendController {
    private final RecommendService recommendService;

    @PostMapping("/{userId}/{boardId}")
    public ResponseEntity<Recommend> upRecommend(@PathVariable Integer userId, @PathVariable Integer boardId) {
        Recommend recommend = recommendService.upRecommend(userId, boardId);
        return ResponseEntity.ok(recommend);
    }

    @DeleteMapping("/recommend/{userId}/{boardId}")
    public ResponseEntity<Void> deleteRecommend(@PathVariable Integer userId, @PathVariable Integer boardId) {
        recommendService.deleteRecommend(userId, boardId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("recommends/{userId}/{boardId}")
    public ResponseEntity<Boolean> checkRecommend(@PathVariable Integer userId, @PathVariable Integer boardId) {
        Boolean exist = recommendService.checkRecommend(userId, boardId);
        return ResponseEntity.ok(exist);
    }

    @GetMapping("/board/recommends/count/{boardId}")
    public ResponseEntity<Integer> boardAllCheck(@PathVariable Integer boardId){
        Integer count = recommendService.boardAllCheck(boardId);
        return ResponseEntity.ok(count);
    }
}
