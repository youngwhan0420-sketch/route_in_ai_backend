package com.routeinai.backend.board.mapper;

import com.routeinai.backend.board.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    void insertBoard(Board board);
    void deleteBoard(Integer boardId);
    Optional<Board> findByBoardId(Integer boardId);
    List<Board> findAllBoardList();
    List<Board> findBoardByUserId(Integer userId);
    void updateBoard(Board board);
}
