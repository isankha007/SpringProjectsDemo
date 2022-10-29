package com.example.demo.common;

import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorResponseDto {
	@NonNull
	private String message;
	
}
