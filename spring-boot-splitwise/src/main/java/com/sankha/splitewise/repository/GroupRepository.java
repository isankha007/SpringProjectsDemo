package com.sankha.splitewise.repository;

import java.util.List;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankha.splitewise.model.Group;
import com.sankha.splitewise.model.User;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
	Group save(Group group);
	//Optional<Group> findByGroupId(Long groupId);
	  //List<Group> findAllByParticipantsContaining(List<User> users); //wrong
	    // select * from groups
	    // where participants in ()
	
     List<Group> findByParticipantsIn(List<User> participants);
	
}
