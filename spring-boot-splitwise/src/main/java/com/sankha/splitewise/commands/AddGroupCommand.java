package com.sankha.splitewise.commands;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sankha.splitewise.controller.GroupController;
import com.sankha.splitewise.dto.AddGroupRequestDto;
import com.sankha.splitewise.dto.AddGroupResponseDto;

@Service
public class AddGroupCommand implements Command{

	@Autowired
	private GroupController groupController;
	
	@Override
	public boolean parse(String commandLine) {
		// TODO Auto-generated method stub
		List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
		
		
		 if (commandTokens.size() != 3) {
	            System.out.println("This is not an add group command");
	            return false;
	        }
		 if (!commandTokens.get(1).equals(CommandKeywords.ADD_GROUP_COMMAND)) {
	            System.out.println("This is not an add group command");
	            return false;
	        }
		 System.out.println("This is an add group command");
	     return true;
	}

	@Override
	public void execute(String commandLine) {
		// TODO Auto-generated method stub
		  List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
	        String username = commandTokens.get(0);
	        String groupName = commandTokens.get(2);
	       

	        AddGroupRequestDto registerUserRequestDto = new AddGroupRequestDto();
	        registerUserRequestDto.setAdminName(username);
	        registerUserRequestDto.setGroupName(groupName);

	        AddGroupResponseDto response = groupController.addGroup(registerUserRequestDto);
	        System.out.println(response.getGroup());
		
	}

}
