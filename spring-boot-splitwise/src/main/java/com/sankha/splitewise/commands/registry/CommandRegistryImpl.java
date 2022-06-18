package com.sankha.splitewise.commands.registry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sankha.splitewise.commands.Command;

@Service
public class CommandRegistryImpl implements CommandRegistry {

	private List<Command> commands=new ArrayList<>();
	
	
	@Override
	public void registerCommand(Command command) {
		// TODO Auto-generated method stub
		commands.add(command);

	}

	@Override
	public Command getCommand(String commandLine) {
		// TODO Auto-generated method stub
		for(Command command:commands) {
			if(command.parse(commandLine))
					return command;
		}
		return null;
	}

	@Override
	public void removeCommand(Command command) {
		// TODO Auto-generated method stub
			commands.remove(command);
	}

	@Override
	public boolean executeCommandLine(String commandLine) {
		// TODO Auto-generated method stub
		for(Command command:commands) {
			if(command.parse(commandLine)) {
				command.execute(commandLine);
			}
		}
		return false;
	}

}
