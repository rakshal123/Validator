package com.personal.validator.dto;

import com.personal.validator.validCheckAnnotations.ValidEmail;

public record UserDTO(
        String name,
        @ValidEmail String email,
        String phoneNumber
) {
}
