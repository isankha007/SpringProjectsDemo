package com.sankha.splitewise.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankha.splitewise.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User save(User user);
	Optional<User> findUserById(Long id);
	Optional<User> findByUsername(String userName);;
	
	//List<User> findUsersByUsernameAndPhonenumber();

}
