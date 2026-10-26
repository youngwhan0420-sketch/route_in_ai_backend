package com.routeinai.backend.auth.dto.request;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String provider;
    private String providerUserId;

}
