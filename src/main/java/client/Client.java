package client;

import receiver.CommandProcess;
import receiver.CommandProcessForWindows;

import command.Command;
import command.CommandInvoker;

import concretecommand.ConcreteCommand;

public class Client {

	public static void main(String[] args) {
		CommandInvoker invoker = new CommandInvoker();
		
		//确定命令的处理者，构建命令
		CommandProcess process = new CommandProcessForWindows();		
		Command command = new ConcreteCommand(process);
		
		invoker.setCommand(command);
		invoker.action();
	}
}
