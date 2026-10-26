package com.routeinai.backend.board.mapper;

import com.routeinai.backend.board.entity.BoardCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface BoardCourseMapper {
    Optional<BoardCourse> findByBoardId(Integer boardId);
    Optional<BoardCourse> findByCourseId(Integer courseId);
    void insertBoardCourse(BoardCourse boardCourse);
    void deleteBoardCourse(Integer boardId);
}
