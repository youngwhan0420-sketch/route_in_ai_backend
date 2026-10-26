package com.routeinai.backend.board.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateBoard {
    private String type;
    private String title;
    private String content;
    private String tags;
}
