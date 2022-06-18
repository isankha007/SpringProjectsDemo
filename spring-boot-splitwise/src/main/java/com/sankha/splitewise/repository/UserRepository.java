package com.sankha.splitewise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankha.splitewise.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User save(User user);
	User findUserById(Long id);
	//List<User> findUsersByUsernameAndPhonenumber();

}
