package com.routeinai.backend.board.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangeComment {
    private Integer boardId;
    private Integer courseId;
    private String content;

}
