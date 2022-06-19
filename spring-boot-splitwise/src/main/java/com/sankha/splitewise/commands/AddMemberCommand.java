package com.sankha.splitewise.commands;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sankha.splitewise.controller.GroupController;
import com.sankha.splitewise.dto.AddGroupRequestDto;
import com.sankha.splitewise.dto.AddGroupResponseDto;
import com.sankha.splitewise.dto.AddMemberRequestDto;
import com.sankha.splitewise.dto.AddMemberResponseDto;

@Service
public class AddMemberCommand implements Command{

	@Autowired
	private GroupController groupController;
	
	@Override
	public boolean parse(String commandLine) {
		// TODO Auto-generated method stub
		List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
		
		
		 if (commandTokens.size() != 4) {
	            System.out.println("This is not an add member command");
	            return false;
	        }
		 if (!commandTokens.get(1).equals(CommandKeywords.ADD_MEMBER_COMMAND)) {
	            System.out.println("This is not an add member command");
	            return false;
	        }
		 System.out.println("This is an add member command");
	     return true;
	}

	@Override
	public void execute(String commandLine) {
		// TODO Auto-generated method stub
		  	List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
	        String username = commandTokens.get(0);
	        String groupId = commandTokens.get(2);
	        String memberName = commandTokens.get(3);
	       

	        AddMemberRequestDto addMemberRequestDto = new AddMemberRequestDto();
	        addMemberRequestDto.setAdminName(username);
	        addMemberRequestDto.setGroupId(groupId);
	        addMemberRequestDto.setMemberName(memberName);

	        AddMemberResponseDto response = groupController.addMember(addMemberRequestDto);
	        System.out.println(response.getGroup());
		
	}

}
