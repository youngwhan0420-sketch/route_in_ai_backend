package com.routeinai.backend.board.service;

import com.routeinai.backend.board.entity.BoardCourse;
import com.routeinai.backend.board.mapper.BoardCourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardCourseService {
    private final BoardCourseMapper boardCourseMapper;

    public BoardCourse createBoardCourse(Integer boardId,Integer courseId) {
        boolean boardExist = boardCourseMapper.findByBoardId(boardId).isPresent();

        if(boardExist) {
            throw new RuntimeException("이미 연결된 게시물입니다.");
        }

        boolean courseExist = boardCourseMapper.findByCourseId(courseId).isPresent();

        if(courseExist) {
            throw new RuntimeException("이미 연결된 코스입니다.");
        }

        BoardCourse boardCourse = BoardCourse.builder()
                .boardId(boardId)
                .courseId(courseId)
                .build();

        boardCourseMapper.insertBoardCourse(boardCourse);

        return boardCourseMapper.findByBoardId(boardId).orElseThrow(() -> new RuntimeException("게시글 코스 연결 조회에 실패했습니다."));
    }
    public BoardCourse getBoardCourse(Integer boardId) {
        return boardCourseMapper.findByBoardId(boardId).orElseThrow(() -> new RuntimeException("게시글에 연결된 코스가 없습니다."));
    }
    public void deleteBoardCourse(Integer boardId) {
         boardCourseMapper.findByBoardId(boardId).orElseThrow(() -> new RuntimeException("게시글에 연결된 코스가 없습니다."));
         boardCourseMapper.deleteBoardCourse(boardId);
    }

}
