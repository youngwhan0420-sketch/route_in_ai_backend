package com.routeinai.backend.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recommend {
    private Integer recommendId;
    private Integer userId;
    private Integer boardId;
    private LocalDateTime createDt;
}
