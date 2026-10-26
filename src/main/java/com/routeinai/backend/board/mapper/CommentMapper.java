package com.routeinai.backend.board.mapper;

import com.routeinai.backend.board.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommentMapper {
    void updateComment(Comment comment);
    void softDeleteComment(Integer commentId);
    void insertComment(Comment comment);
    List<Comment> findByBoardId(Integer boardId);
    List<Comment> findByUserId(Integer userId);
    Optional<Comment> findByCommentId(Integer commentId);
}
