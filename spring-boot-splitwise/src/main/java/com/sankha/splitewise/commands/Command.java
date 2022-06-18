package com.sankha.splitewise.commands;

public interface Command {
	boolean parse(String commandLine);
	void execute(String commandLine);

}
