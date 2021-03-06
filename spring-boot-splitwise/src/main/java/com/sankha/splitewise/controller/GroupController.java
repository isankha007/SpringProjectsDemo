package com.sankha.splitewise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sankha.splitewise.dto.AddGroupRequestDto;
import com.sankha.splitewise.dto.AddGroupResponseDto;
import com.sankha.splitewise.dto.AddMemberRequestDto;
import com.sankha.splitewise.dto.AddMemberResponseDto;
import com.sankha.splitewise.model.Group;
import com.sankha.splitewise.model.User;
import com.sankha.splitewise.service.group.GroupService;
import com.sankha.splitewise.service.user.UserService;

@Controller
public class GroupController {
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private UserService userService;
	
	public AddGroupResponseDto addGroup(AddGroupRequestDto request) {
		User user=userService.getUserByName(request.getAdminName());
		Group group = null;
		if(user!=null) {
			 group=groupService.addGroup(user, request.getGroupName());
		}
		
		AddGroupResponseDto response=new AddGroupResponseDto();
		response.setGroup(group);
		return response;
		
		
	} 
	
	public AddMemberResponseDto addMember(AddMemberRequestDto request) {
		User user=userService.getUserByName(request.getMemberName());
		Group group = null;
		if(user!=null) {
			 group=groupService.addMember(request.getGroupId(),user);
		}
		
		AddMemberResponseDto response=new AddMemberResponseDto();
		response.setGroup(group);
		return response;
		
		
	} 
}
