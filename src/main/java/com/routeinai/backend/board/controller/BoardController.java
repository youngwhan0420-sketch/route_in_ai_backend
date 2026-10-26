package com.routeinai.backend.board.controller;

import com.routeinai.backend.board.dto.request.ChangeBoard;
import com.routeinai.backend.board.dto.request.CreateBoard;
import com.routeinai.backend.board.entity.Board;
import com.routeinai.backend.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<Board> createBoard(@PathVariable Integer userId, @RequestBody CreateBoard createBoard) {
        Board boardCreate = boardService.createBoard(userId, createBoard);
        return ResponseEntity.ok(boardCreate);
    }

    @GetMapping("/detail/{boardId}")
    public ResponseEntity<Board> boardDetail(@PathVariable Integer boardId) {
        Board boardDetail = boardService.boardDetail(boardId);
        return ResponseEntity.ok(boardDetail);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Board>> allBoardList() {
        List<Board> boardAllList = boardService.allBoardList();
        return ResponseEntity.ok(boardAllList);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Board>> userBoardList(@PathVariable Integer userId) {
        List<Board> boardList = boardService.userBoardList(userId);
        return ResponseEntity.ok(boardList);

    }

    @PutMapping("/update/{boardId}")
    public ResponseEntity<Board> updateBoard(@PathVariable Integer boardId, @RequestBody ChangeBoard changeBoard) {
        Board boardUpdate = boardService.updateBoard(boardId, changeBoard);
        return ResponseEntity.ok(boardUpdate);
    }

    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Integer boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.ok().build();

    }
}
