package client;

import receiver.CommandProcess;
import receiver.CommandProcessForWindows;

import command.Command;
import command.CommandInvoker;

import concretecommand.ConcreteCommand;

public class Client {

	public static void main(String[] args) {
		CommandInvoker invoker = new CommandInvoker();
		
		//ȷ������Ĵ����ߣ���������
		CommandProcess process = new CommandProcessForWindows();		
		Command command = new ConcreteCommand(process);
		
		invoker.setCommand(command);
		invoker.action();
	}
}
