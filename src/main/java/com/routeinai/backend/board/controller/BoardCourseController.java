package com.routeinai.backend.board.controller;

import com.routeinai.backend.board.entity.BoardCourse;
import com.routeinai.backend.board.service.BoardCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boardcourse")
@RequiredArgsConstructor
public class BoardCourseController {
    private final BoardCourseService boardCourseService;

    @PostMapping("/{boardId}/{courseId}")
    public ResponseEntity<BoardCourse> createBoardCourse(
            @PathVariable Integer boardId, @PathVariable Integer courseId
    ) {
        BoardCourse boardCourse = boardCourseService.createBoardCourse(boardId, courseId);
        return ResponseEntity.ok(boardCourse);
    }

    @GetMapping("/course/{boardId}")
    public ResponseEntity<BoardCourse> getBoardCourse(@PathVariable Integer boardId) {
        BoardCourse boardCourse = boardCourseService.getBoardCourse(boardId);
        return ResponseEntity.ok(boardCourse);
    }

    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<Void> deleteBoardCourse(@PathVariable Integer boardId) {
        boardCourseService.deleteBoardCourse(boardId);
        return ResponseEntity.ok().build();
    }

}
