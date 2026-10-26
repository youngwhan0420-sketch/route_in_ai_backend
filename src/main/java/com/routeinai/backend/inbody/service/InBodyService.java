package com.routeinai.backend.inbody.service;

import com.routeinai.backend.inbody.dto.request.CreateInBody;
import com.routeinai.backend.inbody.entity.InBody;
import com.routeinai.backend.inbody.mapper.InBodyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InBodyService {
    private final InBodyMapper inBodyMapper;

    public InBody createInBody(Integer userId, CreateInBody createInBody) {
        InBody inBody = InBody.builder()
                .userId(userId)
                .weight(createInBody.getWeight())
                .skeletalMuscleMass(createInBody.getSkeletalMuscleMass())
                .bodyFatMass(createInBody.getBodyFatMass())
                .measuredDt(createInBody.getMeasuredDt())
                .build();
        inBodyMapper.insertInBody(inBody);
        return inBodyMapper.findByMeasurementId(inBody.getMeasurementId()).orElseThrow(()
                -> new RuntimeException("인바디 기록 조회에 실패했습니다.."));
    }

    public List<InBody> getInBody(Integer userId) {
        return inBodyMapper.findAllInBodyByUserId(userId);
    }

    public InBody getRecentInBody(Integer userId) {
        return inBodyMapper.findRecentInBodyByUserId(userId).orElseThrow(()
                -> new RuntimeException("등록된 인바디가 없습니다."));
    }
}
