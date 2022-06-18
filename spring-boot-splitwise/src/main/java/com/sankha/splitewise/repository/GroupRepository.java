package com.sankha.splitewise.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankha.splitewise.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
	Group save(Group group);
	//Optional<Group> findByGroupId(Long groupId);
	
}
