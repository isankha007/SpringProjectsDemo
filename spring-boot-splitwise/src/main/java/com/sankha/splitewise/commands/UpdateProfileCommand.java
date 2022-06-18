package com.sankha.splitewise.commands;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sankha.splitewise.controller.UserController;
import com.sankha.splitewise.dto.UpdateProfileRequestDto;
import com.sankha.splitewise.dto.UpdateProfileResponseDto;

@Service
public class UpdateProfileCommand implements Command {

    private UserController userController;

    @Autowired
    public UpdateProfileCommand(UserController userController) {
        this.userController = userController;
    }
	@Override
	public boolean parse(String commandLine) {
		// TODO Auto-generated method stub
		List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
		
		 if (commandTokens.size() != 3) {
	            System.out.println("This is not a Update profile command");
	            return false;
	        }
		 if (!commandTokens.get(1).equals(CommandKeywords.UPDATE_PROFILE_COMMAND)) {
	            System.out.println("This is not a Update User command");
	            return false;
	        }
		 System.out.println("This is a Update profile command");
	     return true;
	}

	@Override
	public void execute(String commandLine) {
		List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
        Long userId = Long.parseLong(commandTokens.get(0));
        String newPassword = commandTokens.get(2);

        UpdateProfileRequestDto request = new UpdateProfileRequestDto();
        request.setNewPassword(newPassword);
        request.setUserId(userId);

        UpdateProfileResponseDto response = userController.updateProfile(request);

        System.out.println(response.getUser());

	}

}
