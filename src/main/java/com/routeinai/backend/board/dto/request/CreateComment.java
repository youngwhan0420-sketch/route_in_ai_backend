package com.routeinai.backend.board.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateComment {
    private Integer parentId;
    private String content;
}
