package com.personal.validator.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDTO {
    private String name;
    private String email;
    private String phoneNumber;
}
