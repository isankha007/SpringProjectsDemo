package com.sankha.splitewise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileRequestDto {

    private Long userId;
    private String newPassword;
}
