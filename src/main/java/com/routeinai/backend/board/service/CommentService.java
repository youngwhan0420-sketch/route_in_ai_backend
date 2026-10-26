package com.routeinai.backend.board.service;

import com.routeinai.backend.board.dto.request.ChangeComment;
import com.routeinai.backend.board.dto.request.CreateComment;
import com.routeinai.backend.board.entity.Comment;
import com.routeinai.backend.board.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper commentMapper;

    public Comment createComment(Integer userId, Integer boardId, CreateComment createComment){
        Comment comment = Comment.builder()
                .userId(userId)
                .boardId(boardId)
                .parentId(createComment.getParentId())
                .content(createComment.getContent())
                .build();
        commentMapper.insertComment(comment);
        return commentMapper.findByCommentId(comment.getCommentId()).orElseThrow(() -> new RuntimeException("댓글 조회에 실패했습니다."));

    }
    public List<Comment> getCommentBoardId(Integer boardId) {
        return commentMapper.findByBoardId(boardId);
    }
    public Comment getOneComment(Integer commentId) {
        return commentMapper.findByCommentId(commentId).orElseThrow(() -> new RuntimeException("댓글이 존재하지 않습니다."));


    }
    public List<Comment> getCommentUserId(Integer userId) {
        return commentMapper.findByUserId(userId);


    }
    public void updateComment(Integer commentId, ChangeComment changeComment) {
        commentMapper.findByCommentId(commentId).orElseThrow(() -> new RuntimeException("댓글이 존재하지 않습니다."));

        Comment comment = Comment.builder()
                .commentId(commentId)
                .content(changeComment.getContent())
                .build();
        commentMapper.updateComment(comment);


    }
    public void deleteComment(Integer commentId) {
        commentMapper.findByCommentId(commentId).orElseThrow(() -> new RuntimeException("댓글이 존재하지 않습니다."));
        commentMapper.softDeleteComment(commentId);

    }
}
