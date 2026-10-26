package com.routeinai.backend.board.service;

import com.routeinai.backend.board.dto.request.ChangeBoard;
import com.routeinai.backend.board.dto.request.CreateBoard;
import com.routeinai.backend.board.entity.Board;
import com.routeinai.backend.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public Board createBoard(Integer userId, CreateBoard createBoard) {
        Board boardCreate = Board.builder()
                .userId(userId)
                .type(createBoard.getType())
                .title(createBoard.getTitle())
                .content(createBoard.getContent())
                .tags(createBoard.getTags())
                .build();

        boardMapper.insertBoard(boardCreate);

        return boardMapper.findByBoardId(boardCreate.getBoardId()).orElseThrow(() -> new RuntimeException("게시글 조회에 실패했습니다."));
    }

    public Board boardDetail(Integer boardId) {
        return boardMapper.findByBoardId(boardId).orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));

    }

    public List<Board> allBoardList() {
        return boardMapper.findAllBoardList();
    }
    public List<Board> userBoardList(Integer userId) {
        return boardMapper.findBoardByUserId(userId);
    }

    public Board updateBoard(Integer boardId, ChangeBoard changeBoard) {
        boardMapper.findByBoardId(boardId).orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다. "));
        Board updateBoard = Board.builder()
                .boardId(boardId)
                .type(changeBoard.getType())
                .title(changeBoard.getTitle())
                .content(changeBoard.getContent())
                .tags(changeBoard.getTags())
                .build();
        boardMapper.updateBoard(updateBoard);

        return boardMapper.findByBoardId(boardId).orElseThrow(() -> new RuntimeException("게시글 조회에 실패했습니다."));
    }
    public void deleteBoard(Integer boardId) {
        boardMapper.findByBoardId(boardId).orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
        boardMapper.deleteBoard(boardId);
    }



}
