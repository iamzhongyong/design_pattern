package command.concretecommand;

import command.Command;
import command.receiver.CommandProcess;

public class ConcreteCommand implements Command{
	private CommandProcess receiver;	
	@Override
	public void execute() {
		this.receiver.doSomething();
	}
	public ConcreteCommand(CommandProcess receiver) {
		super();
		this.receiver = receiver;
	}	
}
