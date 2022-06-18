package com.sankha.splitewise.commands;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sankha.splitewise.controller.UserController;
import com.sankha.splitewise.dto.RegisterUserRequestDto;
import com.sankha.splitewise.dto.RegisterUserResponseDto;

@Service
public class RegisterUserCommand implements Command{
	@Autowired
	private UserController userController;
	
	
	public RegisterUserCommand(UserController userController) {
		this.userController=userController;
	}

	@Override
	public boolean parse(String commandLine) {
		// TODO Auto-generated method stub
		List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
		
		
		 if (commandTokens.size() != 4) {
	            System.out.println("This is not a Register User command");
	            return false;
	        }
		 if (!commandTokens.get(0).equals(CommandKeywords.REGISTER_USER_COMMAND)) {
	            System.out.println("This is not a Register User command");
	            return false;
	        }
		 System.out.println("This is a Register User command");
	     return true;
	}

	@Override
	public void execute(String commandLine) {
		  List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
	        String username = commandTokens.get(1);
	        String phoneNumber = commandTokens.get(2);
	        String password = commandTokens.get(3);

	        RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
	        registerUserRequestDto.setPassword(password);
	        registerUserRequestDto.setUsername(username);
	        registerUserRequestDto.setPhoneNumber(phoneNumber);

	        RegisterUserResponseDto response = userController.registerUser(registerUserRequestDto);

	        System.out.println(response.getUser());
		
	}

}
