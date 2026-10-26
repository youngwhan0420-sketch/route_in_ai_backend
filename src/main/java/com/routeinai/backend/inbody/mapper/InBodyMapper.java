package com.routeinai.backend.inbody.mapper;

import com.routeinai.backend.inbody.entity.InBody;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface InBodyMapper {
    void insertInBody(InBody inBody);
    Optional<InBody> findByMeasurementId(Integer measurementId);
    Optional<InBody> findRecentInBodyByUserId(Integer userId);
    List<InBody> findAllInBodyByUserId(Integer userId);
}
