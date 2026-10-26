package com.routeinai.backend.address.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangeAddress {
    private String zipCode;
    private String baseAddress;
    private String detailAddress;
}
