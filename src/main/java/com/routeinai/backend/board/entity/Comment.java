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
public class Comment {
    private Integer commentId;
    private Integer boardId;
    private Integer userId;
    private Integer parentId;
    private String content;
    private Boolean isDeleted;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
}
