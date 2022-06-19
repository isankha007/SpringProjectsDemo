package com.sankha.splitewise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sankha.splitewise.commands.AddGroupCommand;
import com.sankha.splitewise.commands.AddMemberCommand;
import com.sankha.splitewise.commands.RegisterUserCommand;
import com.sankha.splitewise.commands.UpdateProfileCommand;
import com.sankha.splitewise.commands.registry.CommandRegistry;
import com.sankha.splitewise.commands.registry.CommandRegistryImpl;

@SpringBootApplication
public class SpringBootSplitwiseApplication implements CommandLineRunner{
	@Autowired
	private CommandRegistry commandRegistry;
	
	@Autowired
	private RegisterUserCommand registerUserCommand;
	
	@Autowired
	private UpdateProfileCommand updateProfileCommand;
	
	@Autowired
	private AddGroupCommand addGroupCommand;
	
	@Autowired
	private AddMemberCommand addMemberCommand;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSplitwiseApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		CommandRegistry commandRegistry= new CommandRegistryImpl();
        commandRegistry.registerCommand(registerUserCommand);
        commandRegistry.registerCommand(updateProfileCommand);
        commandRegistry.registerCommand(addGroupCommand);
        commandRegistry.registerCommand(addMemberCommand);
//
       // String input = "Register u34 999 password";
       // String input = "u34 AddGroup Roommates34";
        String input="u1 AddMember 1 u34"; //"u1 AddMember g1 u2";
//       // String input = "5 UpdateProfile strongpassword";
        commandRegistry.executeCommandLine(input);
		
		
//		while(true) {
//			String intput= "Register vinsmokesanji 003 namisswwaann";
//			commandRegistry.executeCommandLine(intput);
//		}
		
	}

}
