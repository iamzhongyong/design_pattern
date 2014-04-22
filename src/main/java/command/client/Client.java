package command.client;

import command.Command;
import command.CommandInvoker;
import command.concretecommand.ConcreteCommand;
import command.receiver.CommandProcess;
import command.receiver.CommandProcessForWindows;

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
