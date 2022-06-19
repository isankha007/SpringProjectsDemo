package com.sankha.splitewise.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sankha.splitewise.model.User;
import com.sankha.splitewise.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	UserService(UserRepository userRepository){
		this.userRepository=userRepository;
	}
	
	public User registerUser(String phoneNumber,
							String password,
							String username) {
		User user =new User();
		user.setUsername(username);
		user.setHashedPassword(password);
		user.setPhoneNumber(phoneNumber);
		
		 User user1 = userRepository.save(user);
		return user1;
	}
	
	public User updateProfile(Long userId, String newPassword) {
        User user = userRepository.findUserById(userId).get();
        user.setHashedPassword(newPassword);
        User savedUser = userRepository.save(user);
        return savedUser;
    }
	
	public User getUserByName(String UserName) {
		if(userRepository.findByUsername(UserName).isPresent()) {
	        User user= userRepository.findByUsername(UserName).get();
	        return user;
		}
		return null;

    }

}
