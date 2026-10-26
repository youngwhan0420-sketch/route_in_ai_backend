package com.routeinai.backend.board.mapper;

import com.routeinai.backend.board.entity.Recommend;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface RecommendMapper {
    void deleteRecommend(Recommend recommend);
    void insertRecommend(Recommend recommend);
    Integer countByBoardId(Integer boardId);
    Optional<Recommend> findByUserIdAndBoardId(Recommend recommend);
}
