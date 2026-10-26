package com.routeinai.backend.board.service;

import com.routeinai.backend.board.entity.Recommend;
import com.routeinai.backend.board.mapper.RecommendMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendService {
    private final RecommendMapper recommendMapper;

    public Recommend upRecommend(Integer userId, Integer boardId) {
        Recommend recommend = Recommend.builder()
                .userId(userId)
                .boardId(boardId)
                .build();
        Boolean recommendExist = recommendMapper.findByUserIdAndBoardId(recommend).isPresent();

        if(recommendExist) {
            throw new RuntimeException("이미 추천한 게시글입니다.");
        }
        recommendMapper.insertRecommend(recommend);

        return recommendMapper.findByUserIdAndBoardId(recommend).orElseThrow(() -> new RuntimeException("추천 조회에 실패했습니다."));

    }
    public void deleteRecommend(Integer userId, Integer boardId) {
        Recommend recommend = Recommend.builder()
                .userId(userId)
                .boardId(boardId)
                .build();
        recommendMapper.findByUserIdAndBoardId(recommend).orElseThrow(() -> new RuntimeException("추천 정보가 존재하지 않습니다."));

        recommendMapper.deleteRecommend(recommend);



    }
    public Boolean checkRecommend(Integer userId, Integer boardId) {
        Recommend recommend = Recommend.builder()
                .userId(userId)
                .boardId(boardId)
                .build();
        return recommendMapper.findByUserIdAndBoardId(recommend).isPresent();

    }
    public Integer boardAllCheck(Integer boardId) {
        return recommendMapper.countByBoardId(boardId);

    }
}
