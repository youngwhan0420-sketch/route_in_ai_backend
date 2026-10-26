package com.routeinai.backend.board.controller;


import com.routeinai.backend.board.dto.request.ChangeComment;
import com.routeinai.backend.board.dto.request.CreateComment;
import com.routeinai.backend.board.entity.Comment;
import com.routeinai.backend.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/create/{userId}/{boardId}")
    public ResponseEntity<Comment> createComment(@PathVariable Integer userId, @PathVariable Integer boardId,
                                                 @RequestBody CreateComment createComment) {
        Comment insertComment = commentService.createComment(userId, boardId, createComment);
        return ResponseEntity.ok(insertComment);

    }
    @GetMapping("/comment/boardId/{boardId}")
    public ResponseEntity<List<Comment>> getCommentBoardId(@PathVariable Integer boardId) {
        List<Comment> getComment = commentService.getCommentBoardId(boardId);
        return ResponseEntity.ok(getComment);

    }
    @GetMapping("/one/{commentId}")
    public ResponseEntity<Comment> getOneComment(@PathVariable Integer commentId) {
        Comment oneComment = commentService.getOneComment(commentId);
        return ResponseEntity.ok(oneComment);

    }

    @GetMapping("/comment/{userId}")
    public ResponseEntity<List<Comment>> getCommentUserId(@PathVariable Integer userId) {
        List<Comment> userIdComment = commentService.getCommentUserId(userId);
        return ResponseEntity.ok(userIdComment);

    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable Integer commentId, @RequestBody ChangeComment changeComment) {
        commentService.updateComment(commentId, changeComment);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();

    }


}
