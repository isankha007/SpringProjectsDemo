package com.sankha.rest.webservices.restfulWebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResources {
	@Autowired
	private UserDaoService service;
	
	@Autowired
	private UserRepository UserRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retriveAllUser(){
		return UserRepository.findAll();
		
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+ id);
		
		
		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
		EntityModel<User> resource = EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retriveAllUser());
		
		resource.add(linkTo.withRel("all-users"));
		
		//HATEOAS
		
		return resource;
	}
	
//	@GetMapping("/jpa/users/{id}")
//	public EntityModel<User> retriveUser(@PathVariable int id){
//		Optional<User> user = UserRepository.findById(id);
//		if(!user.isPresent()) {
//			throw new UserNotFoundException("id-"+id);
//		}
//		EntityModel<User> model=EntityModel.of(user.get());
//		
//		WebMvcLinkBuilder linkToUser=linkTo(methodOn(this.getClass(), retriveAllUser()));
//		model.add(linkToUser.withRel("all-users"));
//		
//		return model;
//		
//	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		User saveduser = service.save(user);
		URI location=ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}").buildAndExpand(saveduser.getId())
		.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void delteUserById(@PathVariable int id){
		User user = service.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		
	}
	
	
	
	

}
