package com.sankha.splitewise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sankha.splitewise.dto.RegisterUserRequestDto;
import com.sankha.splitewise.dto.RegisterUserResponseDto;
import com.sankha.splitewise.dto.UpdateProfileRequestDto;
import com.sankha.splitewise.dto.UpdateProfileResponseDto;
import com.sankha.splitewise.model.User;
import com.sankha.splitewise.service.user.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	public RegisterUserResponseDto registerUser(RegisterUserRequestDto request) {
		
		User user =  userService.registerUser(
                request.getPhoneNumber(),
                request.getPassword(),
                request.getUsername()
        );
		
		RegisterUserResponseDto registerUserResponseDto=new RegisterUserResponseDto();
		registerUserResponseDto.setUser(user);
		return registerUserResponseDto;
		
	}
	
	public UpdateProfileResponseDto updateProfile(UpdateProfileRequestDto request) {
        User user = userService.updateProfile(
                request.getUserId(),
                request.getNewPassword()
        );

        UpdateProfileResponseDto response = new UpdateProfileResponseDto();
        response.setUser(user);
        return response;
    }
}
