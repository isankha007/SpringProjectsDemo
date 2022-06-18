package com.sankha.splitewise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sankha.splitewise.model.Group;
import com.sankha.splitewise.model.User;
import com.sankha.splitewise.repository.GroupRepository;

@Service
public class GroupService {
	@Autowired
	private GroupRepository groupRepository;
	
	public Group addGroup(User admin,String groupName) {
		Group group= new Group();
		List<User> admins= new ArrayList<>();
		admins.add(admin);
		group.setAdmins(admins);
		group.setName(groupName);
		Group group1=groupRepository.save(group);
		return group1;
	}

}
